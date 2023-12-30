package com.hospital.modual.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.modual.login.pojo.entity.DoctorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 醫生登錄持久层
 * @author psh
 * @since date 2023/12/30
 */
@Mapper
public interface DoctorMapper extends BaseMapper<DoctorEntity> {
}
