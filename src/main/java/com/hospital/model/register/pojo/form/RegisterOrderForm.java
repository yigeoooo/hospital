package com.hospital.model.register.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * 分页条件查询接参对象
 * @author psh
 * @since date 2024/1/8
 */
@Data
public class RegisterOrderForm extends PageForm {

    private String patientId;

    private String doctorId;

    private String date;

    private boolean status;

}
