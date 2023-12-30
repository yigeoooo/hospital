package com.hospital.modual.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.mapper.PatientMapper;
import com.hospital.modual.login.pojo.entity.PatientEntity;
import com.hospital.modual.login.service.PatientIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者登录服务层
 * @author psh
 * @since date 2023/12/30
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, PatientEntity> implements PatientIService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public boolean login(BaseForm baseForm) {
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", baseForm.getId())
                .eq("password", baseForm.getPassword());
        Long count = patientMapper.selectCount(query);
        if (count == 0) {
            return false;
        }
        return true;
    }
}
