package com.hospital.modual.login.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.pojo.entity.DoctorEntity;
import com.hospital.modual.login.pojo.form.DoctorForm;
import com.hospital.modual.login.pojo.form.RootForm;


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

    /**
     * 分页条件查询
     * @param doctorForm
     * @return Page
     */
    Page<DoctorEntity> page(DoctorForm doctorForm);

    /**
     * 修改状态
     * @param doctorForm
     */
    void changeStatus(DoctorForm doctorForm);


    /**
     * 逻辑删除root账号
     * @param id
     */
    boolean deleted(String id);

    /**
     * 新增root账户
     * @param doctorForm
     * @return boolean
     */
    boolean insert(DoctorForm doctorForm);

    /**
     * 修改root账户信息
     * @param doctorForm
     * @return boolean
     */
    boolean edit(DoctorForm doctorForm);

}
