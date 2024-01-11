package com.hospital.model.register.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * 挂号表实体类
 * @author psh
 * @since date 2024/1/8
 */
@Data
@Builder
@TableName("register_order")
public class RegisterOrderEntity {
    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 医生姓名
     */
    private String doctorName;
    /**
     * 日期
     */
    private String date;
    /**
     * 时间
     */
    private String time;
    /**
     * 患者ID
     */
    private String patientId;
    /**
     * 患者姓名
     */
    private String patientName;
    /**
     * 患者性别
     */
    private String patientGender;
    /**
     * 患者身份证号
     */
    private String idCard;
    /**
     * 患者联系电话
     */
    private String phoneNumber;
    /**
     * 就诊状态0未就诊/1已就诊
     */
    private boolean status;
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
    private long sort;
    /**
     * 逻辑删除标识符
     */
    @TableLogic
    private String isDeleted;

}
