package com.hospital.model.medicine.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import com.hospital.model.medicine.pojo.form.MedicineAddForm;
import com.hospital.model.medicine.pojo.form.MedicineForm;
import com.hospital.model.medicine.pojo.form.MedicineUpdateForm;
import com.hospital.model.medicine.service.MedicineIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 药品前端交互层
 * @author psh
 * @since date 2024/1/6
 */
@RestController
@RequestMapping("/saas/medicine")
public class MedicineController {

    @Autowired
    private MedicineIService medicineIService;

    /**
     * 新增药品
     * @param medicineAddForm medicineAddForm对象
     * @return ResultInfo
     */
    @PostMapping("/topic")
    public ResultInfo<Boolean> insert(@RequestBody MedicineAddForm medicineAddForm) {
        try {
            medicineIService.insert(medicineAddForm);
            return ResultInfo.build(true);
        } catch (Exception e) {
            return ResultInfo.build(false, "id重复,无法插入,请稍候尝试");
        }
    }

    /**
     * 分页条件查询
     * @param medicineForm 基本分页查询对象
     * @return ResultInfo
     */
    @PostMapping("/page")
    public ResultInfo<Page<MedicineEntity>> page(@RequestBody MedicineForm medicineForm) {
        return ResultInfo.build(medicineIService.page(medicineForm));
    }

    /**
     * 查询数量
     * @return ResultInfo
     */
    @GetMapping("/count")
    public ResultInfo<Long> count() {
        return ResultInfo.build(medicineIService.count());
    }

    /**
     * 删除信息
     * @param id medicineId
     * @return ResultInfo
     */
    @DeleteMapping("/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        medicineIService.delete(id);
        return ResultInfo.build(true);
    }

    /**
     * 更新药品数量
     * @param id id
     * @param count 数量
     * @return ResultInfo
     */
    @PatchMapping("/{id}/{count}")
    public ResultInfo<Boolean> updateCount(@PathVariable("id") String id,
                                           @PathVariable("count") Long count) {
        medicineIService.updateCount(id, count);
        return ResultInfo.build(true);
    }

    /**
     * 更新medicine信息
     * @param medicineUpdateForm 接惨对象
     * @return
     */
    @PatchMapping("/update")
    public ResultInfo<Boolean> update(@RequestBody MedicineUpdateForm medicineUpdateForm) {
        medicineIService.update(medicineUpdateForm);
        return ResultInfo.build(true);
    }

}
