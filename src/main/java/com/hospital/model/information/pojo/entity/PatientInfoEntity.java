package com.hospital.model.information.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * 患者实信息体类
 * @author psh
 * @since date 2024/1/3
 */
@Data
@TableName("patient_info")
public class PatientInfoEntity {

    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 患者登录id
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
