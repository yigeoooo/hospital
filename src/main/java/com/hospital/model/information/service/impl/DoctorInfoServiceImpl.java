package com.hospital.model.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.information.dao.DoctorInfoDao;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import com.hospital.model.information.pojo.form.DoctorInfoAddForm;
import com.hospital.model.information.pojo.form.DoctorInfoEditForm;
import com.hospital.model.information.pojo.form.DoctorInfoForm;
import com.hospital.model.information.service.DoctorInfoIService;
import com.hospital.model.login.dao.DoctorDao;
import com.hospital.model.login.pojo.entity.DoctorEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医生信息服务层实现类
 * @author psh
 * @since date 2024/1/2
 */
@Service
public class DoctorInfoServiceImpl extends ServiceImpl<DoctorInfoDao, DoctorInfoEntity> implements DoctorInfoIService {

    @Autowired
    private DoctorInfoDao doctorInfoDao;

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public Page<DoctorInfoEntity> page(DoctorInfoForm doctorInfoForm) {
        Page<DoctorInfoEntity> pages = new Page<>(doctorInfoForm.getPage(), doctorInfoForm.getSize());
        QueryWrapper<DoctorInfoEntity> query = new QueryWrapper<>();
        //条件参数拼接
        if (StringUtils.isNotEmpty(doctorInfoForm.getDoctorId())) {
            query.eq("doctor_id", doctorInfoForm.getDoctorId());
        }
        if (StringUtils.isNotEmpty(doctorInfoForm.getDoctorName())) {
            query.eq("doctor_name", doctorInfoForm.getDoctorName());
        }
        Page<DoctorInfoEntity> page = doctorInfoDao.selectPage(pages, query);
        return page;
    }

    @Override
    public boolean insert(DoctorInfoAddForm doctorInfoAddForm) {
        DoctorInfoEntity doctorInfoEntity = new DoctorInfoEntity();
        //检验密码表是否存在该id
        String doctorId = doctorInfoAddForm.getDoctorId();
        QueryWrapper<DoctorEntity> query = new QueryWrapper<>();
        query.eq("doctor_id", doctorId);
        Long count = doctorDao.selectCount(query);
        if (count == 0) {
            //id不存在
            return false;
        }
        //查询是否重复
        QueryWrapper<DoctorInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id", doctorId);
        Long temp = doctorInfoDao.selectCount(queryWrapper);
        if (temp != 0) {
            return false;
        }
        //不重复，封装信息,
        doctorInfoEntity.setDoctorId(doctorInfoAddForm.getDoctorId());
        doctorInfoEntity.setDoctorName(doctorInfoAddForm.getDoctorName());
        doctorInfoEntity.setDoctorGender(doctorInfoAddForm.getDoctorGender());
        doctorInfoEntity.setIdCard(doctorInfoAddForm.getIdCard());
        doctorInfoEntity.setPhoneNumber(doctorInfoAddForm.getPhoneNumber());
        doctorInfoDao.insert(doctorInfoEntity);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int i = doctorInfoDao.deleteById(id);
        if (i == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(DoctorInfoEditForm doctorInfoEditForm) {
        //封装对象
        DoctorInfoEntity doctorInfoEntity = new DoctorInfoEntity();
        doctorInfoEntity.setId(doctorInfoEditForm.getId());
        doctorInfoEntity.setDoctorId(doctorInfoEditForm.getDoctorId());
        doctorInfoEntity.setDoctorName(doctorInfoEditForm.getDoctorName());
        doctorInfoEntity.setIdCard(doctorInfoEditForm.getIdCard());
        doctorInfoEntity.setPhoneNumber(doctorInfoEditForm.getPhoneNumber());
        int i = doctorInfoDao.updateById(doctorInfoEntity);
        if (i == 0) {
            return false;
        }
        return true;
    }
}
