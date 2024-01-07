package com.hospital.model.Scheduling.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.Scheduling.pojo.entity.SchedulingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 排班表实体类
 * @author psh
 * @since date 2024/1/7
 */
@Mapper
public interface SchedulingDao extends BaseMapper<SchedulingEntity> {
}
