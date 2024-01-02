package com.hospital.modual.information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.modual.information.pojo.entity.DoctorInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生信息数据库持久层
 * @author psh
 * @since date 2024/1/2
 */
@Mapper
public interface DoctorInfoMapper extends BaseMapper<DoctorInfoEntity> {
}
