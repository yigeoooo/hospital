package com.hospital.model.login.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.model.login.pojo.entity.DoctorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 醫生登錄持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface DoctorDao extends BaseMapper<DoctorEntity> {

    Page<DoctorEntity> page(Page<DoctorEntity> page, @Param("ew") QueryWrapper<DoctorEntity> ew);
}
