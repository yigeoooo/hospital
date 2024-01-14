package com.hospital.model.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.model.information.dao.PatientInfoDao;
import com.hospital.model.information.pojo.entity.PatientInfoEntity;
import com.hospital.model.login.dao.PatientDao;
import com.hospital.model.login.pojo.entity.PatientEntity;
import com.hospital.model.login.pojo.form.PatientForm;
import com.hospital.model.login.pojo.form.PatientRegisterForm;
import com.hospital.model.login.service.PatientIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 患者登录服务层
 * @author psh
 * @since date 2023/12/30
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientDao, PatientEntity> implements PatientIService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientInfoDao patientInfoDao;

    @Override
    public boolean login(BaseForm baseForm) {
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", baseForm.getId())
                .eq("password", baseForm.getPassword())
                .eq("status", "1");
        Long count = patientDao.selectCount(query);
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Page<PatientEntity> page(PatientForm patientForm) {
        Page<PatientEntity> page = new Page<>(patientForm.getPage(), patientForm.getSize());
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
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

    @Override
    @Transactional
    public void register(PatientRegisterForm patientRegisterForm) {
        String patientId = patientRegisterForm.getPatientId();
        String password = patientRegisterForm.getPassword();
        //验证patientId是否存在
        QueryWrapper<PatientEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        Long count = patientDao.selectCount(queryWrapper);
        if (count != 0) {
            throw new RuntimeException("账户ID已经存在！");
        }
        //插入账户密码表
        PatientEntity patientEntity = PatientEntity
                .builder()
                .patientId(patientId)
                .password(password)
                .status(true)
                .build();
        patientDao.insert(patientEntity);
        //插入患者信息表
        PatientInfoEntity patientInfoEntity = PatientInfoEntity
                .builder()
                .patientId(patientId)
                .patientAge(patientRegisterForm.getPatientAge())
                .patientGender(patientRegisterForm.getPatientGender())
                .patientName(patientRegisterForm.getPatientName())
                .idCard(patientRegisterForm.getIdCard())
                .phoneNumber(patientRegisterForm.getPhoneNumber())
                .build();
        patientInfoDao.insert(patientInfoEntity);
    }
}
