package com.hospital.model.register.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.register.dao.MedicineAdviceDao;
import com.hospital.model.register.pojo.entity.MedicineAdviceEntity;
import com.hospital.model.register.service.MedicineAdviceIService;
import org.springframework.stereotype.Service;

/**
 * 医嘱用药表服务层实现类
 * @author psh
 * @since date 2024/1/13
 */
@Service("MedicineAdviceServiceImpl")
public class MedicineAdviceServiceImpl extends ServiceImpl<MedicineAdviceDao, MedicineAdviceEntity> implements MedicineAdviceIService {
}
