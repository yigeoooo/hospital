package com.hospital.model.information.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生信息数据库持久层
 * @author psh
 * @since date 2024/1/2
 */
@Mapper
public interface DoctorInfoDao extends BaseMapper<DoctorInfoEntity> {
}
