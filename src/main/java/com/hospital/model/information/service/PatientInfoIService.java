package com.hospital.model.information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.information.pojo.entity.PatientInfoEntity;
import com.hospital.model.information.pojo.form.PatientInfoAddForm;
import com.hospital.model.information.pojo.form.PatientInfoEditForm;
import com.hospital.model.information.pojo.form.PatientInfoForm;

/**
 * 患者信息服务层接口
 * @author psh
 * @since date 2024/1/3
 */
public interface PatientInfoIService extends IService<PatientInfoEntity> {

    /**
     * 分页条件查询
     * @return Page
     */
    Page<PatientInfoEntity> page(PatientInfoForm patientInfoForm);

    /**
     * 新增患者
     * @param patientInfoAddForm 接参对象
     * @return boolean
     */
    boolean insert(PatientInfoAddForm patientInfoAddForm);

    /**
     * 逻辑删除患者
     * @param id id
     * @return boolean
     */
    boolean delete(String id);

    /**
     * 查询患者详情
     * @param patientId patientId
     * @return PatientInfoEntity
     */
    PatientInfoEntity info(String patientId);

    /**
     * 患者信息修改
     * @param patientInfoEditForm 接参对象
     * @return boolean
     */
    boolean edit(PatientInfoEditForm patientInfoEditForm);

}
