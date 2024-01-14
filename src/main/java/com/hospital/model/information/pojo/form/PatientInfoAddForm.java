package com.hospital.model.information.pojo.form;

import lombok.Data;


/**
 * 新增患者form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class PatientInfoAddForm {

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
     * 患者年龄
     */
    private String patientAge;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phoneNumber;




}
