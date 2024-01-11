package com.hospital.model.scheduling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.information.dao.DoctorInfoDao;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import com.hospital.model.scheduling.dao.SchedulingDao;
import com.hospital.model.scheduling.pojo.entity.SchedulingEntity;
import com.hospital.model.scheduling.pojo.form.SchedulingEditForm;
import com.hospital.model.scheduling.pojo.form.SchedulingForm;
import com.hospital.model.scheduling.pojo.form.SchedulingListForm;
import com.hospital.model.scheduling.pojo.form.SchedulingSearchForm;
import com.hospital.model.scheduling.service.SchedulingIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 排班表服务层实现类
 * @author psh
 * @since date 2024/1/7
 */
@Service("SchedulingServiceImpl")
public class SchedulingServiceImpl extends ServiceImpl<SchedulingDao, SchedulingEntity> implements SchedulingIService {

    @Autowired
    private SchedulingDao schedulingDao;

    @Autowired
    private SchedulingIService schedulingIService;

    @Autowired
    private DoctorInfoDao doctorInfoDao;

    @Override
    public void insert(SchedulingListForm schedulingListForm) {
        List<SchedulingForm> list = schedulingListForm.getItem();
        //封装实体类数组
        List<SchedulingEntity> entityList = new ArrayList<>();
        list.forEach(item -> {
            entityList.add(SchedulingEntity.builder()
                            .doctorName(item.getDoctorName())
                            .date(item.getDate())
                            .time(item.getTime())
                            .count(item.getCount())
                            .build());
        });
        schedulingIService.saveBatch(entityList);
    }

    @Override
    public Page<SchedulingEntity> page(SchedulingSearchForm schedulingSearchForm) {
        //构筑分页信息
        Page<SchedulingEntity> page = new Page<>();
        page.setCurrent(schedulingSearchForm.getPage());
        page.setSize(schedulingSearchForm.getSize());
        //拼接查询信息
        QueryWrapper<SchedulingEntity> query = new QueryWrapper<>();
        String doctorName = schedulingSearchForm.getDoctorName();
        query.eq("doctor_name", doctorName);
        String date = schedulingSearchForm.getDate();
        if (StringUtils.isNotEmpty(date)) {
            query.eq("date", date);
        }
        return schedulingDao.selectPage(page, query);
    }

    @Override
    public Page<SchedulingEntity> getPage(SchedulingSearchForm schedulingSearchForm) {
        //构筑分页信息
        Page<SchedulingEntity> page = new Page<>();
        page.setCurrent(schedulingSearchForm.getPage());
        page.setSize(schedulingSearchForm.getSize());
        //拼接查询信息
        QueryWrapper<SchedulingEntity> query = new QueryWrapper<>();
        String doctorName = schedulingSearchForm.getDoctorName();
        String date = schedulingSearchForm.getDate();
        String time = schedulingSearchForm.getTime();
        if (StringUtils.isNotEmpty(date)) {
            query.eq("date", date);
        }
        if (StringUtils.isNotEmpty(doctorName)) {
            query.eq("doctor_name", doctorName);
        }
        return schedulingDao.selectPage(page, query);
    }

    @Override
    public Page<SchedulingEntity> getSchedulingPage(SchedulingSearchForm schedulingSearchForm) {
        //查询医生姓名
        String doctorId = schedulingSearchForm.getDoctorId();
        QueryWrapper<DoctorInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id", doctorId);
        boolean exists = doctorInfoDao.exists(queryWrapper);
        if (!exists) {
            throw new RuntimeException("查无此医生信息！");
        }
        DoctorInfoEntity doctorInfoEntity = doctorInfoDao.selectOne(queryWrapper);
        String doctorName = doctorInfoEntity.getDoctorName();
        //查询该医生排班计划
        QueryWrapper<SchedulingEntity> query = new QueryWrapper<>();
        query.eq("doctor_name", doctorName);
        //条件拼接
        String date = schedulingSearchForm.getDate();
        if (StringUtils.isNotEmpty(date)) {
            query.eq("date", date);
        }
        query.eq("is_deleted", "0");
        Page<SchedulingEntity> page = new Page<>();
        page.setCurrent(schedulingSearchForm.getPage());
        page.setSize(schedulingSearchForm.getSize());
        return schedulingDao.getPages(page, query);
    }

    @Override
    public void edit(SchedulingEditForm schedulingEditForm) {
        //构建实体类对象
        SchedulingEntity schedulingEntity = SchedulingEntity
                .builder()
                .id(schedulingEditForm.getId())
                .date(schedulingEditForm.getDate())
                .time(schedulingEditForm.getTime())
                .updateTime(LocalDate.now())
                .build();
        //编辑
        schedulingDao.updateById(schedulingEntity);
    }
}
