package com.hospital.model.information.pojo.form;

import lombok.Data;


/**
 * 新增医生form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class DoctorInfoAddForm {

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




}
