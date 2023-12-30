package com.hospital.modual.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.pojo.entity.DoctorEntity;

/**
 * 医生登录表服务层接口
 * @author yigeoooo
 * @since date 2023/12/30
 */
public interface DoctorIService extends IService<DoctorEntity> {

    /**
     * 医生登录
     * @param baseForm
     * @return boolean
     */
    boolean doctorLogin(BaseForm baseForm);

}
