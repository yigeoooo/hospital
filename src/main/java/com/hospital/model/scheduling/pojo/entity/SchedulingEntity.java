package com.hospital.model.scheduling.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
* 排班表实体类
* @author psh
*/
@Data
@Builder
@TableName("scheduling")
public class SchedulingEntity implements Serializable {

    /**
    * 主键
    */
    @TableId
    private String id;
    /**
    * 医生姓名
    */
    private String doctorName;
    /**
    * 年月日
    */
    private String date;
    /**
    * 时分秒
    */
    private String time;
    /**
    * 可挂号数量
    */

    private Long count;
    /**
    * 更新时间
    */
    private LocalDate updateTime;
    /**
    * 插入时间
    */
    private LocalDate insertTime;
    /**
    * 逻辑删除标识符
    */
    @TableLogic
    private String isDeleted;



}
