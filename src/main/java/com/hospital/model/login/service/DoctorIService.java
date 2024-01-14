package com.hospital.model.login.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.model.login.pojo.entity.DoctorEntity;
import com.hospital.model.login.pojo.form.DoctorForm;


/**
 * 医生登录表服务层接口
 * @author yigeoooo
 * @since date 2023/12/30
 */
public interface DoctorIService extends IService<DoctorEntity> {

    /**
     * 医生登录
     * @param baseForm 接参对象
     * @return boolean
     */
    boolean doctorLogin(BaseForm baseForm);

    /**
     * 分页条件查询
     * @param doctorForm 接参对象
     * @return Page
     */
    Page<DoctorEntity> page(DoctorForm doctorForm);

    /**
     * 修改状态
     * @param doctorForm 接参对象
     */
    void changeStatus(DoctorForm doctorForm);


    /**
     * 逻辑删除doctor账号 接参对象
     * @param id
     */
    boolean deleted(String id);

    /**
     * 新增doctor账户
     * @param doctorForm 接参对象
     * @return boolean
     */
    boolean insert(DoctorForm doctorForm);

    /**
     * 修改doctor账户信息
     * @param doctorForm 接参对象
     * @return boolean
     */
    boolean edit(DoctorForm doctorForm);

}
