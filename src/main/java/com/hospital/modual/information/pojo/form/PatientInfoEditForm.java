package com.hospital.modual.information.pojo.form;

import lombok.Data;

/**
 * 患者信息修改form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class PatientInfoEditForm {

    /**
     * 主键id
     */
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
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phoneNumber;

}
