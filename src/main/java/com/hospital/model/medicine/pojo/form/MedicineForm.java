package com.hospital.model.medicine.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;

/**
 * 基本查询对象
 * @author psh
 * @since date 2024/1/6
 */
@Data
public class MedicineForm extends PageForm {

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

}
