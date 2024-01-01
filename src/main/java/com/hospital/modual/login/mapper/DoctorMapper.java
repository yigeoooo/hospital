package com.hospital.modual.login.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.modual.login.pojo.entity.DoctorEntity;
import com.hospital.modual.login.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 醫生登錄持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface DoctorMapper extends BaseMapper<DoctorEntity> {

    Page page(Page<DoctorEntity> page, @Param("ew") QueryWrapper<DoctorEntity> ew);
}
