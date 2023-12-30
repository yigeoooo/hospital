package com.hospital.modual.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.mapper.DoctorMapper;
import com.hospital.modual.login.pojo.entity.DoctorEntity;
import com.hospital.modual.login.service.DoctorIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医生登录信息表服务层
 * @author psh
 * @since date 2023/12/30
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, DoctorEntity> implements DoctorIService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public boolean doctorLogin(BaseForm baseForm) {
        String doctorId = baseForm.getId();
        String password = baseForm.getPassword();
        QueryWrapper<DoctorEntity> query = new QueryWrapper<>();
        query.eq("doctor_id", doctorId)
                .eq("password", password);
        Long count = doctorMapper.selectCount(query);
        if (count == 0) {
            return false;
        }
        return true;
    }
}
