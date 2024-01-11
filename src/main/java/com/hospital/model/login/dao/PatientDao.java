package com.hospital.model.login.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.model.login.pojo.entity.PatientEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 患者登录持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface PatientDao extends BaseMapper<PatientEntity> {

    Page<PatientEntity> page(Page<PatientEntity> page, @Param("ew") QueryWrapper<PatientEntity> ew);
}
