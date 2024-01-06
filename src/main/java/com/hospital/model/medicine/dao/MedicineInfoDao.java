package com.hospital.model.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.medicine.pojo.entity.MedicineInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品信息持久层
 * @author psh
 * @since date 2024/1/6
 */
@Mapper
public interface MedicineInfoDao extends BaseMapper<MedicineInfoEntity> {
}
