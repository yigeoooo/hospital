package com.hospital.model.login.pojo.form;

import lombok.Data;

/**
 * 注册接参对象
 * @author psh
 * @since date 2024/1/14
 */
@Data
public class PatientRegisterForm {

    private String patientId;

    private String password;

    private String patientName;

    private String patientAge;

    private String patientGender;

    private String idCard;

    private String phoneNumber;


}
