package com.hospital.model.medicine.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 药品实体类
 * @author psh
 * @since date 2024/1/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("medicine")
public class MedicineEntity {

    /**
     * 主键ID
     */
    @TableId
    private String id;

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     *药品数量
     */
    private Long count;

    /**
     * 排序标识符
     */
    private Long sort;

    /**
     * 插入时间
     */
    private LocalDate insertTime;

    /**
     * 最近更新时间
     */
    private LocalDate updateTime;

    /**
     * 逻辑删除标识符
     */
    @TableLogic
    private String isDeleted;
}
