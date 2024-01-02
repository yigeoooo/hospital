package com.hospital.modual.information.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * 医生信息实体类
 * @author psh
 * @since date 2024/1/2
 */
@Data
@TableName("doctor_info")
public class DoctorInfoEntity {
    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 医生登录id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 医生性别
     */
    private String doctorGender;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phoneNumber;

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
