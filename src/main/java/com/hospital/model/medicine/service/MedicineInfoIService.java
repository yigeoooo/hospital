package com.hospital.model.medicine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.medicine.pojo.entity.MedicineInfoEntity;
import com.hospital.model.medicine.pojo.form.MedicineInfoUpdateForm;

/**
 * 药品信息服务层接口
 * @author psh
 * @since date 2024/1/6
 */
public interface MedicineInfoIService extends IService<MedicineInfoEntity>{

    /**
     * 查询药品详情
     * @param medicineId medicineId
     * @return MedicineInfoEntity
     */
    MedicineInfoEntity getInfo(String medicineId);

    /**
     * 修改详情
     * @param param 接惨对象
     */
    void updateInfo(MedicineInfoUpdateForm param);

}
