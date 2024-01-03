package com.hospital.modual.information.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * 患者信息form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class PatientInfoForm extends PageForm {

    /**
     * 患者登录id
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;

}
