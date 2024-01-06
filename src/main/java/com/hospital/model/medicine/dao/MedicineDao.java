package com.hospital.model.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * 药品持久层
 * @author psh
 * @since date 2024/1/6
 */
@Mapper
public interface MedicineDao extends BaseMapper<MedicineEntity> {

    /**
     * 药品数量入库
     * @param id id
     * @param count 数量
     * @return Integer
     */
    Integer updateCount(@Param("id") String id,
                        @Param("count") Long count,
                        @Param("now") LocalDate now);

}
