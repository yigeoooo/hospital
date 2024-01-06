package com.hospital.model.information.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * 医生信息form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class DoctorInfoForm extends PageForm {

    /**
     * 医生登录id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;

}
