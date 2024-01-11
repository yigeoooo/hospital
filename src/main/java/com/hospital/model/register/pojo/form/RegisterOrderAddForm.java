package com.hospital.model.register.pojo.form;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDate;

/**
 * 挂号订单表新增接参对象
 * @author psh
 * @since date 2024/1/8
 */
@Data
public class RegisterOrderAddForm {
    /**
     * 排班表ID
     */
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
     * 患者身份证号
     */
    private String idCard;
    /**
     * 患者性别
     */
    private String patientGender;
    /**
     * 患者联系电话
     */
    private String phoneNumber;

}
