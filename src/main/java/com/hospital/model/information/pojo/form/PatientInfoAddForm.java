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
     * 医生登录id
     */
    private String patientId;

    /**
     * 医生姓名
     */
    private String patientName;

    /**
     * 医生性别
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




}
