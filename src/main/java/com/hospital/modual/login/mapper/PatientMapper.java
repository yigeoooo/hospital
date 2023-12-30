package com.hospital.modual.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.modual.login.pojo.entity.PatientEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 患者登录持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface PatientMapper extends BaseMapper<PatientEntity> {
}
