package com.hospital.modual.login.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * 医生账号form类
 * @author psh
 * @since date 2024/1/1
 */
@Data
public class DoctorForm extends PageForm {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户id
     */
    private String doctorId;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private boolean status;
}
