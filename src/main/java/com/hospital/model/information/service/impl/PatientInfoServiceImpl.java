package com.hospital.model.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.information.dao.PatientInfoDao;
import com.hospital.model.information.pojo.entity.PatientInfoEntity;
import com.hospital.model.information.pojo.form.PatientInfoAddForm;
import com.hospital.model.information.pojo.form.PatientInfoEditForm;
import com.hospital.model.information.pojo.form.PatientInfoForm;
import com.hospital.model.information.service.PatientInfoIService;
import com.hospital.model.login.dao.PatientDao;
import com.hospital.model.login.pojo.entity.PatientEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 患者信息服务层实现类
 * @author psh
 * @since date 2024/1/3
 */
@Service("PatientInfoServiceImpl")
public class PatientInfoServiceImpl extends ServiceImpl<PatientInfoDao, PatientInfoEntity> implements PatientInfoIService {

    @Autowired
    private PatientInfoDao patientInfoDao;

    @Autowired
    private PatientDao patientDao;


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
        Page<PatientInfoEntity> page = patientInfoDao.selectPage(pages, query);
        List<PatientInfoEntity> records = page.getRecords();
        for (PatientInfoEntity record : records) {
            String phoneNumber = record.getPhoneNumber();
            String substring = phoneNumber.substring(0, 3);
            String substring1 = phoneNumber.substring(phoneNumber.length() - 4);
            String s = substring + "*****" + substring1;
            record.setPhoneNumber(s);

            String idCard = record.getIdCard();
            String str = idCard.substring(0, 3);
            String substring2 = idCard.substring(idCard.length() - 4);
            String s1 = str + "************" + substring2;
            record.setIdCard(s1);
        }
        return page;
    }

    @Override
    public boolean insert(PatientInfoAddForm patientInfoAddForm) {
        PatientInfoEntity patientInfoEntity = new PatientInfoEntity();
        //检验密码表是否存在该id
        String patientId = patientInfoAddForm.getPatientId();
        QueryWrapper<PatientEntity> query = new QueryWrapper<>();
        query.eq("patient_id", patientId);
        Long count = patientDao.selectCount(query);
        if (count == 0) {
            //id不存在
            return false;
        }
        //查询是否重复
        QueryWrapper<PatientInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        Long temp = patientInfoDao.selectCount(queryWrapper);
        if (temp != 0) {
            return false;
        }
        //不重复，封装信息,
        patientInfoEntity.setPatientId(patientInfoAddForm.getPatientId());
        patientInfoEntity.setPatientName(patientInfoAddForm.getPatientName());
        patientInfoEntity.setPatientGender(patientInfoAddForm.getPatientGender());
        patientInfoEntity.setIdCard(patientInfoAddForm.getIdCard());
        patientInfoEntity.setPhoneNumber(patientInfoAddForm.getPhoneNumber());
        patientInfoEntity.setPatientAge(patientInfoAddForm.getPatientAge());
        patientInfoDao.insert(patientInfoEntity);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int i = patientInfoDao.deleteById(id);
        if (i == 0) {
            return false;
        }
        return true;
    }

    @Override
    public PatientInfoEntity info(String patientId) {
        //条件构造
        QueryWrapper<PatientInfoEntity> query = new QueryWrapper<>();
        query.eq("patient_id", patientId);
        return patientInfoDao.selectOne(query);
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
        int i = patientInfoDao.updateById(patientInfoEntity);
        if (i == 0) {
            return false;
        }
        return true;
    }
}
