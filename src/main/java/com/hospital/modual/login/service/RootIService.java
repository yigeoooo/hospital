package com.hospital.modual.login.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.pojo.form.RootForm;

/**
 * root账户服务层接口
 * @author psh
 * @since date 2024/1/1
 */
public interface RootIService extends IService<UserEntity> {

    /**
     * 分页条件查询
     * @param rootForm
     * @return Page
     */
    Page<UserEntity> page(RootForm rootForm);

    /**
     * 修改状态
     * @param rootForm
     */
    void changeStatus(RootForm rootForm);

    /**
     * 逻辑删除root账号
     * @param id
     */
    boolean deleted(String id);

    /**
     * 新增root账户
     * @param rootForm
     * @return boolean
     */
    boolean insert(RootForm rootForm);

    /**
     * 修改root账户信息
     * @param rootForm
     * @return boolean
     */
    boolean edit(RootForm rootForm);

}
