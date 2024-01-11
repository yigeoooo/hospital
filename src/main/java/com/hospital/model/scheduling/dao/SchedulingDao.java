package com.hospital.model.scheduling.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.model.scheduling.pojo.entity.SchedulingEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 排班表实体类
 * @author psh
 * @since date 2024/1/7
 */
@Mapper
public interface SchedulingDao extends BaseMapper<SchedulingEntity> {

    int updateCount(@Param("id") String id);

    int reset(@Param("doctorName") String doctorName,
              @Param("date") String date,
              @Param("time") String time);

    Page<SchedulingEntity> getPages(@Param("page") Page<SchedulingEntity> page,
                                    @Param("ew") QueryWrapper<SchedulingEntity> query);
}
