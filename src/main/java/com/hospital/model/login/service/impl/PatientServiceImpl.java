package com.hospital.model.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.model.login.dao.PatientDao;
import com.hospital.model.login.pojo.entity.PatientEntity;
import com.hospital.model.login.pojo.form.PatientForm;
import com.hospital.model.login.service.PatientIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者登录服务层
 * @author psh
 * @since date 2023/12/30
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientDao, PatientEntity> implements PatientIService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public boolean login(BaseForm baseForm) {
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", baseForm.getId())
                .eq("password", baseForm.getPassword());
        Long count = patientDao.selectCount(query);
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Page<PatientEntity> page(PatientForm patientForm) {
        Page<PatientEntity> page = new Page(patientForm.getPage(), patientForm.getSize());
        QueryWrapper<PatientEntity> query = new QueryWrapper();
        String id = patientForm.getId();
        String doctorId = patientForm.getPatientId();
        //参数检验，拼接过滤查询条件
        if (StringUtils.isNotEmpty(id)) {
            query.eq("id", id);
        }
        if (StringUtils.isNotEmpty(doctorId)) {
            query.eq("patient_id", doctorId);
        }
        query.eq("is_deleted", "0");
        return patientDao.page(page, query);
    }

    @Override
    public void changeStatus(PatientForm patientForm) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientForm.getId());
        patientEntity.setStatus(patientForm.isStatus());
        patientDao.updateById(patientEntity);
    }

    @Override
    public boolean deleted(String id) {
        int i = patientDao.deleteById(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(PatientForm patientForm) {
        //验证用户id是否重复
        String patientId = patientForm.getPatientId();
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", patientId);
        Long count = patientDao.selectCount(query);
        if (count == 0) {
            //不重复则如插入
            PatientEntity patientEntity = new PatientEntity();
            patientEntity.setPatientId(patientForm.getPatientId());
            patientEntity.setPassword(patientForm.getPassword());
            patientEntity.setStatus(patientForm.isStatus());
            patientDao.insert(patientEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(PatientForm patientForm) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientForm.getId());
        patientEntity.setPatientId(patientForm.getPatientId());
        patientEntity.setPassword(patientForm.getPassword());
        patientEntity.setStatus(patientForm.isStatus());
        int count = patientDao.updateById(patientEntity);
        if (count == 0) {
            return false;
        }
        return true;
    }
}
