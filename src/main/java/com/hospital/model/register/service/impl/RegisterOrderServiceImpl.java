package com.hospital.model.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.information.dao.DoctorInfoDao;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import com.hospital.model.register.dao.RegisterOrderDao;
import com.hospital.model.register.pojo.dto.RegisterInfoDto;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import com.hospital.model.register.pojo.form.RegisterOrderAddForm;
import com.hospital.model.register.pojo.form.RegisterOrderForm;
import com.hospital.model.register.pojo.form.RegisterOrderResetForm;
import com.hospital.model.register.service.RegisterOrderIService;
import com.hospital.model.scheduling.dao.SchedulingDao;
import com.hospital.model.scheduling.pojo.entity.SchedulingEntity;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 挂号订单表服务层实现类
 * @author psh
 * @since date 2024/1/8
 */
@Service("RegisterOrderServiceImpl")
public class RegisterOrderServiceImpl extends ServiceImpl<RegisterOrderDao, RegisterOrderEntity> implements RegisterOrderIService {

    @Autowired
    private RegisterOrderDao registerOrderDao;

    @Autowired
    private SchedulingDao schedulingDao;

    @Autowired
    private DoctorInfoDao doctorInfoDao;

    @Transactional
    @Override
    public void insert(RegisterOrderAddForm registerOrderAddForm) {
        //查询排班表该条挂号信息可挂号数是否大于0
        String id = registerOrderAddForm.getId();
        SchedulingEntity schedulingEntity = schedulingDao.selectById(id);
        Long count = schedulingEntity.getCount();
        if (count <= 0) {
            throw new RuntimeException("该医生可挂号数为0！");
        }
        //可挂号数量减去1
        schedulingDao.updateCount(id);
        //构建实体类对象
        RegisterOrderEntity registerOrderEntity = RegisterOrderEntity
                .builder()
                .doctorName(registerOrderAddForm.getDoctorName())
                .patientId(registerOrderAddForm.getPatientId())
                .date(registerOrderAddForm.getDate())
                .time(registerOrderAddForm.getTime())
                .patientGender(registerOrderAddForm.getPatientGender())
                .idCard(registerOrderAddForm.getIdCard())
                .patientAge(registerOrderAddForm.getPatientAge())
                .patientName(registerOrderAddForm.getPatientName())
                .phoneNumber(registerOrderAddForm.getPhoneNumber())
                .build();
        //插入
        registerOrderDao.insert(registerOrderEntity);
    }

    @Override
    public Page<RegisterOrderEntity> page(RegisterOrderForm registerOrderForm) {
        //构筑分页信息
        Page<RegisterOrderEntity> page = new Page<>();
        page.setCurrent(registerOrderForm.getPage());
        page.setSize(registerOrderForm.getSize());
        //条件拼接
        String date = registerOrderForm.getDate();
        QueryWrapper<RegisterOrderEntity> query = new QueryWrapper<>();
        query.eq("patient_id", registerOrderForm.getPatientId());
        if (StringUtils.isNotEmpty(date)) {
            query.eq("date", date);
        }
        return registerOrderDao.selectPage(page, query);
    }

    @Override
    public Page<RegisterOrderEntity> pages(RegisterOrderForm registerOrderForm) {
        String doctorId = registerOrderForm.getDoctorId();
        //查询医生姓名
        QueryWrapper<DoctorInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id", doctorId);
        boolean exists = doctorInfoDao.exists(queryWrapper);
        if (!exists) {
            throw new RuntimeException("不存在该医生信息!");
        }
        DoctorInfoEntity doctorInfoEntity = doctorInfoDao.selectOne(queryWrapper);
        String doctorName = doctorInfoEntity.getDoctorName();
        //查询该医生挂号信息
        QueryWrapper<RegisterOrderEntity> query = new QueryWrapper<>();
        query.eq("doctor_name", doctorName);
        String date = registerOrderForm.getDate();
        if (StringUtils.isNotEmpty(date)) {
            query.eq("date", date);
        }
        query.eq("is_deleted", "0");
        query.eq("status", false);
        //构筑分页信息
        Page<RegisterOrderEntity> page = new Page<>();
        page.setCurrent(registerOrderForm.getPage());
        page.setSize(registerOrderForm.getSize());
        return registerOrderDao.getPage(page, query);
    }

    @Transactional
    @Override
    public void reset(RegisterOrderResetForm registerOrderResetForm) {
        //根据id逻辑删除挂号信息
        registerOrderDao.deleteById(registerOrderResetForm.getId());
        //当天医生可挂号数加一
        String doctorName = registerOrderResetForm.getDoctorName();
        String date = registerOrderResetForm.getDate();
        String time = registerOrderResetForm.getTime();
        schedulingDao.reset(doctorName, date, time);
    }

    @Override
    public RegisterInfoDto info(String id) {
        return registerOrderDao.info(id);
    }
}
