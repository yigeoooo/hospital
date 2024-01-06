package com.hospital.model.medicine.pojo.form;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 修改信息接参对象
 * @author psh
 * @since date 2024/1/6
 */
@Data
public class MedicineUpdateForm {

    /**
     * 主键ID
     */
    @TableId
    private String id;

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

}
