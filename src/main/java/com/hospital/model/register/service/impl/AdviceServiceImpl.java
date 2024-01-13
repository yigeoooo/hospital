package com.hospital.model.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.model.medicine.dao.MedicineDao;
import com.hospital.model.medicine.pojo.entity.MedicineEntity;
import com.hospital.model.register.dao.AdviceDao;
import com.hospital.model.register.dao.RegisterOrderDao;
import com.hospital.model.register.pojo.entity.AdviceEntity;
import com.hospital.model.register.pojo.entity.MedicineAdviceEntity;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import com.hospital.model.register.pojo.form.AdviceForm;
import com.hospital.model.register.pojo.form.MedicineAdviceForm;
import com.hospital.model.register.service.AdviceIService;
import com.hospital.model.register.service.MedicineAdviceIService;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 医嘱表服务层实现类
 * @author psh
 * @since date 2024/1/13
 */
@Service("AdviceServiceImpl")
@Slf4j
public class AdviceServiceImpl extends ServiceImpl<AdviceDao, AdviceEntity> implements AdviceIService {

    @Autowired
    private AdviceDao adviceDao;

    @Autowired
    private MedicineAdviceIService medicineAdviceIService;

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private RegisterOrderDao registerOrderDao;

    @Value("${download.path}")
    private String filePath;

    @Override
    @Transactional
    public void insertAdvice(AdviceForm adviceForm) {
        String advice = adviceForm.getAdvice();
        String orderId = adviceForm.getId();
        List<MedicineAdviceForm> list = adviceForm.getMedicineForm();
        //向医嘱信息表插入医嘱信息
        //创建实体类对象
        AdviceEntity adviceEntity = AdviceEntity
                .builder()
                .orderId(orderId)
                .advice(advice)
                .build();
        adviceDao.insert(adviceEntity);
        //向用药医嘱表插入信息
        //创建对象赋值
        List<MedicineAdviceEntity> res = new ArrayList<>();
        list.forEach(item -> {
            String medicineName = item.getMedicineName();
            Long count = item.getCount();
            //更新medicine表药品数量
            //查询药品数量是否足够
            QueryWrapper<MedicineEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("medicine_name", medicineName);
            MedicineEntity medicineEntity = medicineDao.selectOne(queryWrapper);
            Long medicineCount = medicineEntity.getCount();
            if (medicineCount < count) {
                throw new RuntimeException("药品数量不足！");
            }
            //更新数量
            medicineDao.deleteCount(medicineName, count, LocalDate.now());

            MedicineAdviceEntity medicineAdviceEntity = MedicineAdviceEntity
                    .builder()
                    .orderId(orderId)
                    .medicineName(medicineName)
                    .count(count)
                    .build();
            res.add(medicineAdviceEntity);
        });
        //批量插入用药
        medicineAdviceIService.saveBatch(res);
        //修改挂号信息为已处理
        RegisterOrderEntity registerOrderEntity = RegisterOrderEntity
                .builder()
                .id(orderId)
                .status(true)
                .build();
        registerOrderDao.updateById(registerOrderEntity);
    }

    @Override
    public void generatePdf(String id) throws IOException {
        final String dest = "card.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
        String line = "Hello! Welcome to iTextPdf";
        document.add(new Paragraph(line));
        document.close();
//        PdfWriter writer = new PdfWriter(dest);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//        document.add(new Paragraph("Hello World!"));
//        document.close();
    }
}
