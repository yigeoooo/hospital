package com.hospital.model.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.model.medicine.pojo.dto.MedicineDto;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

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
     * @param now 当前日期
     * @return Integer
     */
    Integer updateCount(@Param("id") String id,
                        @Param("count") Long count,
                        @Param("now") LocalDate now);

    /**'
     * 查询药品种类
     * @return List
     * @param medicineName name
     */
    List<MedicineDto> getMedicineList(@Param("medicineName") String medicineName);

    /**
     * 更新药品数量信息
     * @param medicineName 药品名称
     * @param count 数量
     * @param now 当前时间
     * @return Integer
     */
    Integer deleteCount(@Param("medicineName") String medicineName,
                        @Param("count") Long count,
                        @Param("now") LocalDate now);

}
