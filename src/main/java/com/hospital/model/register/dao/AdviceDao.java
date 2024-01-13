package com.hospital.model.register.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.register.pojo.entity.AdviceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医嘱表dao层
 * @author psh
 * @since date 2024/1/13
 */
@Mapper
public interface AdviceDao extends BaseMapper<AdviceEntity> {
}
