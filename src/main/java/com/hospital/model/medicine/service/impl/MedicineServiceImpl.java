package com.hospital.model.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.medicine.dao.MedicineDao;
import com.hospital.model.medicine.dao.MedicineInfoDao;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import com.hospital.model.medicine.pojo.entity.MedicineInfoEntity;
import com.hospital.model.medicine.pojo.form.MedicineAddForm;
import com.hospital.model.medicine.pojo.form.MedicineForm;
import com.hospital.model.medicine.pojo.form.MedicineUpdateForm;
import com.hospital.model.medicine.service.MedicineIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * 药品服务层实现类
 * @author psh
 * @since date 2024/1/6
 */
@Service("MedicineServiceImpl")
public class MedicineServiceImpl extends ServiceImpl<MedicineDao, MedicineEntity> implements MedicineIService {

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private MedicineInfoDao medicineInfoDao;
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void insert(MedicineAddForm medicineAddForm) {
        //构建插入对实体类对象并赋值
        MedicineEntity medicine = MedicineEntity.builder()
                .medicineId(medicineAddForm.getMedicineId())
                .medicineName(medicineAddForm.getMedicineName())
                .count(medicineAddForm.getCount())
                .build();
        //查询medicineId是否重复
        QueryWrapper<MedicineEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("medicine_id", medicineAddForm.getMedicineId());
        Long count = medicineDao.selectCount(queryWrapper);
        if (count != 0) {
            //medicine_id重复，抛出异常
            throw new RuntimeException("药品ID重复");
        }
        //插入medicine表
        medicineDao.insert(medicine);
        //创建medicineInfo实体类,插入信息
        MedicineInfoEntity medicineInfoEntity = MedicineInfoEntity.builder()
                .medicineId(medicineAddForm.getMedicineId())
                .medicineName(medicineAddForm.getMedicineName())
                .build();
        medicineInfoDao.insert(medicineInfoEntity);
    }

    @Override
    public Page<MedicineEntity> page(MedicineForm medicineForm) {
        //构筑分页信息
        Page<MedicineEntity> page = new Page<>(medicineForm.getPage(), medicineForm.getSize());
        //条件拼接
        QueryWrapper<MedicineEntity> query = new QueryWrapper<>();
        String medicineId = medicineForm.getMedicineId();
        String medicineName = medicineForm.getMedicineName();
        if (StringUtils.isNotEmpty(medicineId)) {
            query.eq("medicine_id", medicineId);
        }
        if (StringUtils.isNotEmpty(medicineName)) {
            query.eq("medicine_name", medicineName);
        }
        return medicineDao.selectPage(page, query);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String id) {
        //查询medicineId
        MedicineEntity medicineEntity = medicineDao.selectById(id);
        String medicineId = medicineEntity.getMedicineId();
        //删除从表medicineInfo信息
        QueryWrapper<MedicineInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("medicine_id", medicineId);
        medicineInfoDao.delete(queryWrapper);
        //删除主表medicine信息
        medicineDao.deleteById(id);
    }

    @Override
    public void updateCount(String id, Long count) {
        LocalDate now = LocalDate.now();
        medicineDao.updateCount(id, count, now);
    }
    @Transactional
    @Override
    public void update(MedicineUpdateForm medicineUpdateForm) {
        //更新从表信息
        String medicineId = medicineUpdateForm.getMedicineId();
        //条件构造
        QueryWrapper<MedicineInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("medicine_id", medicineId);
        //构建对象
        MedicineInfoEntity medicineInfoEntity = MedicineInfoEntity
                .builder()
                .medicineName(medicineUpdateForm.getMedicineName())
                .build();
        medicineInfoDao.update(medicineInfoEntity,queryWrapper);
        //更新主表信息
        MedicineEntity medicine = MedicineEntity
                .builder()
                .id(medicineUpdateForm.getId())
                .medicineName(medicineUpdateForm.getMedicineName())
                .build();
        medicineDao.updateById(medicine);
    }
}
