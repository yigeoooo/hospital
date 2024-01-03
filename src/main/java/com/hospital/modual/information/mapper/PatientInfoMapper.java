package com.hospital.modual.information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.modual.information.pojo.entity.PatientInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 患者信息持久层
 * @author psh
 * @since date 2024/1/3
 */
@Mapper
public interface PatientInfoMapper extends BaseMapper<PatientInfoEntity> {
}
