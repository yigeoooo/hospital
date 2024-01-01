package com.hospital.modual.login.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.pojo.entity.PatientEntity;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.pojo.form.PatientForm;
import com.hospital.modual.login.pojo.form.RootForm;

/**
 * 患者登录服务层接口
 * @author psh
 * @since date 2023/12/30
 */
public interface PatientIService extends IService<PatientEntity> {

    /**
     * 患者登录
     * @param baseForm
     * @return boolean
     */
    boolean login(BaseForm baseForm);

    /**
     * 分页条件查询
     * @param patientForm
     * @return Page
     */
    Page<PatientEntity> page(PatientForm patientForm);

    /**
     * 修改状态
     * @param patientForm
     */
    void changeStatus(PatientForm patientForm);

    /**
     * 逻辑删除root账号
     * @param id
     */
    boolean deleted(String id);

    /**
     * 新增root账户
     * @param patientForm
     * @return boolean
     */
    boolean insert(PatientForm patientForm);

    /**
     * 修改root账户信息
     * @param patientForm
     * @return boolean
     */
    boolean edit(PatientForm patientForm);

}
