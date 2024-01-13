package com.hospital.model.register.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.register.pojo.dto.RegisterInfoDto;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import com.hospital.model.register.pojo.form.RegisterOrderAddForm;
import com.hospital.model.register.pojo.form.RegisterOrderForm;
import com.hospital.model.register.pojo.form.RegisterOrderResetForm;

/**
 * 挂号订单表服务层接口
 * @author psh
 * @since date 2024/1/8
 */
public interface RegisterOrderIService extends IService<RegisterOrderEntity> {

    /**
     * 新增挂号订单信息
     * @param registerOrderAddForm 接参对象
     */
    void insert(RegisterOrderAddForm registerOrderAddForm);

    /**
     * 分页条件查询
     * @param registerOrderForm 接惨对象
     * @return Page
     */
    Page<RegisterOrderEntity> page(RegisterOrderForm registerOrderForm);

    /**
     * 查询特定医生挂号信息
     * @param registerOrderForm 接惨对象
     * @return Page
     */
    Page<RegisterOrderEntity> pages(RegisterOrderForm registerOrderForm);

    /**
     * 退号接口
     * @param registerOrderResetForm 接参对象
     */
    void reset(RegisterOrderResetForm registerOrderResetForm);

    /**
     * 查询病例详情
     * @param id id;
     * @return RegisterInfoDto dto对象
     */
    RegisterInfoDto info(String id);

}
