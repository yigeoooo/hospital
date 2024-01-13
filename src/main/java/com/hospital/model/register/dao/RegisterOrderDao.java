package com.hospital.model.register.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.model.register.pojo.dto.RegisterInfoDto;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 患者挂号表持久层
 * @author psh
 * @since date 2024/1/8
 */
@Mapper
public interface RegisterOrderDao extends BaseMapper<RegisterOrderEntity> {

    /**
     * 分页查询
     * @param page page对象
     * @param ew 条件构造器
     * @return Page
     */
    Page<RegisterOrderEntity> getPage(@Param("page") Page<RegisterOrderEntity> page,
                                      @Param("ew")QueryWrapper<RegisterOrderEntity> ew);

    /**
     * 病例详情
     * @param id id
     * @return RegisterInfoDto
     */
    RegisterInfoDto info(@Param("id") String id);
}
