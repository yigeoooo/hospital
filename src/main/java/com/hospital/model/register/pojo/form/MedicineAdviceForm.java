package com.hospital.model.register.pojo.form;

import lombok.Data;

/**
 * 医嘱用药接参对象
 * @author psh
 * @since date 2024/1/13
 */
@Data
public class MedicineAdviceForm {

    private String medicineName;

    private Long count;

}
