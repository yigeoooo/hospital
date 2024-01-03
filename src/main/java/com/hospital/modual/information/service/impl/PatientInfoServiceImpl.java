package com.hospital.modual.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.modual.information.mapper.PatientInfoMapper;
import com.hospital.modual.information.pojo.entity.PatientInfoEntity;
import com.hospital.modual.information.pojo.form.PatientInfoAddForm;
import com.hospital.modual.information.pojo.form.PatientInfoEditForm;
import com.hospital.modual.information.pojo.form.PatientInfoForm;
import com.hospital.modual.information.service.PatientInfoIService;
import com.hospital.modual.login.mapper.PatientMapper;
import com.hospital.modual.login.pojo.entity.PatientEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者信息服务层实现类
 * @author psh
 * @since date 2024/1/3
 */
@Service("PatientInfoServiceImpl")
public class PatientInfoServiceImpl extends ServiceImpl<PatientInfoMapper, PatientInfoEntity> implements PatientInfoIService {

    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    private PatientMapper patientMapper;


    @Override
    public Page<PatientInfoEntity> page(PatientInfoForm patientInfoForm) {
        Page<PatientInfoEntity> pages = new Page<>(patientInfoForm.getPage(), patientInfoForm.getSize());
        QueryWrapper<PatientInfoEntity> query = new QueryWrapper<>();
        //条件参数拼接
        if (StringUtils.isNotEmpty(patientInfoForm.getPatientId())) {
            query.eq("patient_id", patientInfoForm.getPatientId());
        }
        if (StringUtils.isNotEmpty(patientInfoForm.getPatientName())) {
            query.eq("patient_name", patientInfoForm.getPatientName());
        }
        Page<PatientInfoEntity> page = patientInfoMapper.selectPage(pages, query);
        return page;
    }

    @Override
    public boolean insert(PatientInfoAddForm patientInfoAddForm) {
        PatientInfoEntity patientInfoEntity = new PatientInfoEntity();
        //检验密码表是否存在该id
        String patientId = patientInfoAddForm.getPatientId();
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", patientId);
        Long count = patientMapper.selectCount(query);
        if (count == 0) {
            //id不存在
            return false;
        }
        //查询是否重复
        QueryWrapper<PatientInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        Long temp = patientInfoMapper.selectCount(queryWrapper);
        if (temp != 0) {
            return false;
        }
        //不重复，封装信息,
        patientInfoEntity.setPatientId(patientInfoAddForm.getPatientId());
        patientInfoEntity.setPatientName(patientInfoAddForm.getPatientName());
        patientInfoEntity.setPatientGender(patientInfoAddForm.getPatientGender());
        patientInfoEntity.setIdCard(patientInfoAddForm.getIdCard());
        patientInfoEntity.setPhoneNumber(patientInfoAddForm.getPhoneNumber());
        patientInfoMapper.insert(patientInfoEntity);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int i = patientInfoMapper.deleteById(id);
        if (i == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(PatientInfoEditForm patientInfoEditForm) {
        //封装对象
        PatientInfoEntity patientInfoEntity = new PatientInfoEntity();
        patientInfoEntity.setId(patientInfoEditForm.getId());
        patientInfoEntity.setPatientId(patientInfoEditForm.getPatientId());
        patientInfoEntity.setPatientName(patientInfoEditForm.getPatientName());
        patientInfoEntity.setIdCard(patientInfoEditForm.getIdCard());
        patientInfoEntity.setPhoneNumber(patientInfoEditForm.getPhoneNumber());
        int i = patientInfoMapper.updateById(patientInfoEntity);
        if (i == 0) {
            return false;
        }
        return true;
    }
}
