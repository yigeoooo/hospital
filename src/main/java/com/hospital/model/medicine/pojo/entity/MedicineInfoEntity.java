package com.hospital.model.medicine.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * 药品信息实体类
 * @author psh
 * @since date 2024/1/6
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("medicine_info")
public class MedicineInfoEntity {

    /**
    * 主键id
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
    * 药品别名
    */
    private String alias;
    /**
    * 用药部位
    */
    private String medicinalPart;
    /**
    * 产地
    */
    private String producer;
    /**
    * 药性
    */
    private String properties;
    /**
    * 功效
    */
    private String functions;
    /**
    * 禁忌
    */
    private String taboos;
    /**
    * 临床应用
    */
    private String application;
    /**
    * 排序标识符
    */
    private Long sort;
    /**
    * 插入时间
    */
    private LocalDate insertTime;
    /**
    * 更新时间
    */
    private LocalDate updateTime;
    /**
    * 逻辑删除标识符
    */
    @TableLogic
    private String isDeleted;


}
