package com.hospital.model.information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import com.hospital.model.information.pojo.form.DoctorInfoAddForm;
import com.hospital.model.information.pojo.form.DoctorInfoEditForm;
import com.hospital.model.information.pojo.form.DoctorInfoForm;

/**
 * 医生信息服务层接口
 * @author psh
 * @since date 2024/1/2
 */
public interface DoctorInfoIService extends IService<DoctorInfoEntity> {

    /**
     * 分页条件查询
     * @return Page
     */
    Page<DoctorInfoEntity> page(DoctorInfoForm doctorInfoForm);

    /**
     * 新增医生
     * @param doctorInfoAddForm
     */
    boolean insert(DoctorInfoAddForm doctorInfoAddForm);

    /**
     * 逻辑删除医生
     * @param id
     * @return boolean
     */
    boolean delete(String id);

    /**
     * 医生信息修改
     * @param doctorInfoEditForm
     * @return boolean
     */
    boolean edit(DoctorInfoEditForm doctorInfoEditForm);

}
