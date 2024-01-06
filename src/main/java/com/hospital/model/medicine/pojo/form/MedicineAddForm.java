package com.hospital.model.medicine.pojo.form;

import lombok.Data;

/**
 * 药品新增接收对象
 * @author psh
 * @since date 2024/1/6
 */
@Data
public class MedicineAddForm {

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     *药品数量
     */
    private Long count;

}
