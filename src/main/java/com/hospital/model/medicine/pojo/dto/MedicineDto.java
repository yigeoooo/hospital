package com.hospital.model.medicine.pojo.dto;

import lombok.Data;

/**
 * 药品dto对象
 * @author psh
 * @since date 2024/1/11
 */
@Data
public class MedicineDto {

    private String medicineId;

    private String medicineName;

    private Long count;

}
