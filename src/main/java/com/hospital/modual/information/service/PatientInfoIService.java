package com.hospital.modual.information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.modual.information.pojo.entity.PatientInfoEntity;
import com.hospital.modual.information.pojo.entity.PatientInfoEntity;
import com.hospital.modual.information.pojo.form.PatientInfoAddForm;
import com.hospital.modual.information.pojo.form.PatientInfoEditForm;
import com.hospital.modual.information.pojo.form.PatientInfoForm;

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
     * @param patientInfoAddForm
     */
    boolean insert(PatientInfoAddForm patientInfoAddForm);

    /**
     * 逻辑删除患者
     * @param id
     * @return boolean
     */
    boolean delete(String id);

    /**
     * 患者信息修改
     * @param patientInfoEditForm
     * @return boolean
     */
    boolean edit(PatientInfoEditForm patientInfoEditForm);

}
