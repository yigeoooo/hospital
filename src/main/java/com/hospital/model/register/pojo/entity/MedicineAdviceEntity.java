package com.hospital.model.register.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


/**
*
* @author  psh
*/
@Data
@Builder
@TableName("medicine_advice")
public class MedicineAdviceEntity implements Serializable {

    /**
    * 主键id
    */
    @TableId
    private String id;
    /**
    * register_order主键id
    */
    private String orderId;
    /**
    * 药品名称
    */
    private String medicineName;
    /**
    * 药品数量
    */
    private Long count;
    /**
    * 插入时间
    */
    private LocalDate insertTime;
    /**
    * 更新时间
    */
    private LocalDate updateTime;
    /**
    * 排序标识符
    */
    private Long sort;
    /**
    * 逻辑删除标识符
    */
    @TableLogic
    private String isDeleted;


}
