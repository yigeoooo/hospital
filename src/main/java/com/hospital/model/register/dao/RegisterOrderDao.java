package com.hospital.model.register.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 患者挂号表持久层
 * @author psh
 * @since date 2024/1/8
 */
@Mapper
public interface RegisterOrderDao extends BaseMapper<RegisterOrderEntity> {
}
