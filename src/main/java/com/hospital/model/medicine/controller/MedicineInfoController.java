package com.hospital.model.medicine.controller;

import com.hospital.common.utils.ResultInfo;
import com.hospital.model.medicine.pojo.entity.MedicineInfoEntity;
import com.hospital.model.medicine.pojo.form.MedicineInfoUpdateForm;
import com.hospital.model.medicine.service.MedicineInfoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 药品信息交互层
 * @author psh
 * @since date 2024/1/6
 */
@RestController
@RequestMapping("/saas/medicineInfo")
public class MedicineInfoController {

    @Autowired
    private MedicineInfoIService medicineInfoIService;

    /**
     * 查询药品详情
     * @param medicineId medicineId
     * @return ResultInfo
     */
    @GetMapping("/{medicineId}")
    public ResultInfo<MedicineInfoEntity> getOne(@PathVariable("medicineId") String medicineId) {
        return ResultInfo.build(medicineInfoIService.getInfo(medicineId));
    }

    @PutMapping("/update")
    public ResultInfo<Boolean> update(@RequestBody MedicineInfoUpdateForm param) {
        medicineInfoIService.updateInfo(param);
        return ResultInfo.build(true);
    }

}
