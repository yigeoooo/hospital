package com.hospital.model.register.pojo.form;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 病例接参对象
 * @author psh
 * @since date 2024/1/13
 */
@Data
public class AdviceForm {

    private String id;

    private String advice;

    private List<MedicineAdviceForm> medicineForm = new ArrayList<>();

}
