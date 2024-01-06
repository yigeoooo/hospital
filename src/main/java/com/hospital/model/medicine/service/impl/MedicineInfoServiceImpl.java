package com.hospital.model.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.medicine.dao.MedicineInfoDao;
import com.hospital.model.medicine.pojo.entity.MedicineInfoEntity;
import com.hospital.model.medicine.pojo.form.MedicineInfoUpdateForm;
import com.hospital.model.medicine.pojo.form.MedicineUpdateForm;
import com.hospital.model.medicine.service.MedicineInfoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 药品信息服务层实现类
 * @author psh
 * @since date 2024/1/6
 */
@Service("MedicineInfoServiceImpl")
public class MedicineInfoServiceImpl extends ServiceImpl<MedicineInfoDao, MedicineInfoEntity> implements MedicineInfoIService {

    @Autowired
    private MedicineInfoDao medicineInfoDao;

    @Override
    public MedicineInfoEntity getInfo(String medicineId) {
        QueryWrapper<MedicineInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("medicine_id", medicineId);
        return medicineInfoDao.selectOne(queryWrapper);
    }

    @Override
    public void updateInfo(MedicineInfoUpdateForm param) {
        //构建对象
        MedicineInfoEntity medicineInfoEntity = MedicineInfoEntity
                .builder()
                .id(param.getId())
                .medicineName(param.getMedicineName())
                .alias(param.getAlias())
                .medicinalPart(param.getMedicinalPart())
                .producer(param.getProducer())
                .properties(param.getProperties())
                .functions(param.getFunctions())
                .taboos(param.getTaboos())
                .application(param.getApplication())
                .build();
        //更新
        medicineInfoDao.updateById(medicineInfoEntity);
    }
}
