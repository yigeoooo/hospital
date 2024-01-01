package com.hospital.modual.login.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.modual.login.pojo.entity.PatientEntity;
import com.hospital.modual.login.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 患者登录持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface PatientMapper extends BaseMapper<PatientEntity> {

    Page page(Page<PatientEntity> page, @Param("ew") QueryWrapper<PatientEntity> ew);
}
