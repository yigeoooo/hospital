package com.hospital.model.register.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.register.pojo.entity.RegisterOrderEntity;
import com.hospital.model.register.pojo.form.RegisterOrderAddForm;
import com.hospital.model.register.pojo.form.RegisterOrderForm;
import com.hospital.model.register.pojo.form.RegisterOrderResetForm;
import com.hospital.model.register.service.RegisterOrderIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 挂号交互层
 * @author psh
 * @since date 2024/1/8
 */
@RestController
@RequestMapping("/saas/registerOrder")
@Slf4j
public class RegisterOrderController {

    @Autowired
    private RegisterOrderIService registerOrderIService;

    /**
     * 插入订单信息
     * @param registerOrderAddForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/insert")
    public ResultInfo<Boolean> insert(@RequestBody RegisterOrderAddForm registerOrderAddForm) {
        try {
            registerOrderIService.insert(registerOrderAddForm);
            return ResultInfo.build(true);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResultInfo.build(false, e.toString());
        }
    }

    /**
     * 条件分页查询
     * @param registerOrderForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/page")
    public ResultInfo<Page<RegisterOrderEntity>> page(@RequestBody RegisterOrderForm registerOrderForm) {
        return ResultInfo.build(registerOrderIService.page(registerOrderForm));
    }

    /**
     * 条件分页查询
     * @param registerOrderForm 接惨对象
     * @return ResultInfo
     */
    @PostMapping("/pages")
    public ResultInfo<Page<RegisterOrderEntity>> pages(@RequestBody RegisterOrderForm registerOrderForm) {
        return ResultInfo.build(registerOrderIService.pages(registerOrderForm));
    }

    /**
     * 退号处理
     * @param registerOrderResetForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/reset")
    public ResultInfo<Boolean> reset(@RequestBody RegisterOrderResetForm registerOrderResetForm) {
        registerOrderIService.reset(registerOrderResetForm);
        return ResultInfo.build(true);
    }

}
