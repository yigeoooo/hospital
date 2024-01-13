package com.hospital.model.register.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.register.pojo.entity.AdviceEntity;
import com.hospital.model.register.pojo.form.AdviceForm;


import java.io.IOException;

/**
 * 医嘱表服务层接口
 * @author psh
 * @since date 2024/1/13
 */
public interface AdviceIService extends IService<AdviceEntity> {

    /**
     * 新增病例信息
     * @param adviceForm 接参对象
     */
    void insertAdvice(AdviceForm adviceForm);

    /**
     * 生成病例信息pdf
     * @param id id
     */
    void generatePdf(String id) throws IOException;

}
