package com.hospital.model.medicine.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.medicine.pojo.dto.MedicineDto;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import com.hospital.model.medicine.pojo.form.MedicineAddForm;
import com.hospital.model.medicine.pojo.form.MedicineForm;
import com.hospital.model.medicine.pojo.form.MedicineUpdateForm;

import java.util.List;

/**
 * 药品服务层接口
 * @author psh
 * @since date 2024/1/6
 */
public interface MedicineIService extends IService<MedicineEntity> {

    /**
     * 新增药品
     * @param medicineAddForm 药品
     */
    void insert(MedicineAddForm medicineAddForm);

    /**
     * 分页查询
     * @param medicineForm 基本查询对象
     * @return Page
     */
    Page<MedicineEntity> page(MedicineForm medicineForm);

    /**
     * 根据id删除信息
     * @param id id
     */
    void delete(String id);

    /**
     * 药品入库
     * @param id id
     * @param count 数量
     */
    void updateCount(String id, Long count);

    /**
     * 更新medicine信息
     * @param medicineUpdateForm 接参对象
     */
    void update(MedicineUpdateForm medicineUpdateForm);

    /**
     * 查询药品种类
     * @return List
     */
    List<MedicineDto> getMedicineList(String medicineName);

}
