package com.hospital.model.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.model.login.dao.DoctorDao;
import com.hospital.model.login.pojo.entity.DoctorEntity;
import com.hospital.model.login.pojo.form.DoctorForm;
import com.hospital.model.login.service.DoctorIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医生登录信息表服务层
 * @author psh
 * @since date 2023/12/30
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, DoctorEntity> implements DoctorIService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public boolean doctorLogin(BaseForm baseForm) {
        String doctorId = baseForm.getId();
        String password = baseForm.getPassword();
        QueryWrapper<DoctorEntity> query = new QueryWrapper<>();
        query.eq("doctor_id", doctorId)
                .eq("password", password)
                .eq("status", "1");
        Long count = doctorDao.selectCount(query);
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Page<DoctorEntity> page(DoctorForm doctorForm) {
        Page<DoctorEntity> page = new Page<>(doctorForm.getPage(), doctorForm.getSize());
        QueryWrapper<DoctorEntity> query = new QueryWrapper<>();
        String id = doctorForm.getId();
        String doctorId = doctorForm.getDoctorId();
        //参数检验，拼接过滤查询条件
        if (StringUtils.isNotEmpty(id)) {
            query.eq("id", id);
        }
        if (StringUtils.isNotEmpty(doctorId)) {
            query.eq("doctor_id", doctorId);
        }
        query.eq("is_deleted", "0");
        return doctorDao.page(page, query);
    }

    @Override
    public void changeStatus(DoctorForm doctorForm) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorForm.getId());
        doctorEntity.setStatus(doctorForm.isStatus());
        doctorDao.updateById(doctorEntity);
    }

    @Override
    public boolean deleted(String id) {
        int i = doctorDao.deleteById(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(DoctorForm doctorForm) {
        //验证用户id是否重复
        String rootId = doctorForm.getDoctorId();
        QueryWrapper<DoctorEntity> query = new QueryWrapper<>();
        query.eq("doctor_id", rootId);
        Long count = doctorDao.selectCount(query);
        if (count == 0) {
            //不重复则如插入
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setDoctorId(doctorForm.getDoctorId());
            doctorEntity.setPassword(doctorForm.getPassword());
            doctorEntity.setStatus(doctorForm.isStatus());
            doctorDao.insert(doctorEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(DoctorForm doctorForm) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorForm.getId());
        doctorEntity.setDoctorId(doctorForm.getDoctorId());
        doctorEntity.setPassword(doctorForm.getPassword());
        doctorEntity.setStatus(doctorForm.isStatus());
        int count = doctorDao.updateById(doctorEntity);
        if (count == 0) {
            return false;
        }
        return true;
    }

}
