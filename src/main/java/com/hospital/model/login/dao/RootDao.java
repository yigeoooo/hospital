package com.hospital.model.login.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.model.login.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * root账户持久层
 * @author psh
 * @since date 2024/1/1
 */
@Mapper
public interface RootDao extends BaseMapper<UserEntity> {

    Page page(Page<UserEntity> page, @Param("ew") QueryWrapper<UserEntity> ew);

}
