package com.hospital.model.register.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

import java.time.LocalDate;



/**
* 医嘱表实体类
* @author  psh
*/
@Data
@Builder
@TableName("advice")
public class AdviceEntity implements Serializable {

    /**
    * 主键id
    */
    @TableId
    private String id;
    /**
    * register_order表id
    */
    private String orderId;
    /**
    * 医嘱
    */
    private String advice;
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
