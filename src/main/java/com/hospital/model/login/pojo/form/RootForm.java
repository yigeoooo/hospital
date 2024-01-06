package com.hospital.model.login.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * rootForm对象
 * @author psh
 * @since date 2024/1/1
 */
@Data
public class RootForm extends PageForm {


    /**
     * 主键id
     */
    private String id;

    /**
     * 用户id
     */
    private String rootId;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private boolean status;
}
