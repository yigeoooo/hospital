package com.hospital.modual.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.pojo.entity.PatientEntity;

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

}
