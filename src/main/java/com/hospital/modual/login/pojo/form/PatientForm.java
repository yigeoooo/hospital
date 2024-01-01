package com.hospital.modual.login.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/1/1
 */
@Data
public class PatientForm extends PageForm {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户id
     */
    private String patientId;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private boolean status;

}
