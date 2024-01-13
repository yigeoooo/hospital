package com.hospital.model.register.controller;

import com.hospital.common.utils.ResultInfo;
import com.hospital.model.register.pojo.form.AdviceForm;
import com.hospital.model.register.service.AdviceIService;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 医嘱表交互层
 * @author psh
 * @since date 2024/1/13
 */
@RestController
@RequestMapping("/saas/advice")
@Slf4j
public class AdviceController {


    @Autowired
    private AdviceIService adviceIService;

    /**
     * 新增病例
     * @param adviceForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/insert")
    public ResultInfo<Boolean> insert(@RequestBody AdviceForm adviceForm) {
        try {
            adviceIService.insertAdvice(adviceForm);
            return ResultInfo.build(true);
        } catch (Exception e) {
           log.error(e.toString());
           return ResultInfo.build(false);
        }
    }

    /**
     * pdf下载
     * @param id id
     * @throws UnsupportedEncodingException 异常
     */
    @GetMapping("/download/{id}")
    public void down(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        // 文件类型
        response.setContentType("application/pdf");
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("card.pdf", "UTF-8"));
        final String dest = "card.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
        String line = "Hello! Welcome to iTextPdf";
        document.add(new Paragraph(line));
        document.close();
//        adviceIService.generatePdf(id);
//        return ResultInfo.build(true);

    }

}
