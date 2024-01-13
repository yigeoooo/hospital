package com.hospital.model.login.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.login.pojo.entity.PatientEntity;
import com.hospital.model.login.pojo.form.PatientForm;
import com.hospital.model.login.service.PatientIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 患者登录角层
 * @author psh
 * @since date 2023/12/30
 */
@RestController
@RequestMapping("saas/patient")
public class PatientController {

    @Autowired
    private PatientIService patientIService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultInfo<Boolean> login(@RequestBody BaseForm baseForm) {
        return ResultInfo.build(patientIService.login(baseForm));
    }

    /**
     * 分页条件查询
     * @param patientForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo<Page<PatientEntity>> page(@RequestBody PatientForm patientForm) {
        Page<PatientEntity> page = patientIService.page(patientForm);
        return ResultInfo.build(page);
    }

    /**
     * 修改状态
     * @param PatientForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultInfo<Boolean> status(@RequestBody PatientForm PatientForm) {
        patientIService.changeStatus(PatientForm);
        return ResultInfo.build(true);
    }

    /**
     * 逻辑删除root账户
     * @param id id
     * @return ResultInfo
     */
    @GetMapping("/delete/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        boolean bo = patientIService.deleted(id);
        return ResultInfo.build(bo);
    }

    /**
     * 新增管理员账户
     * @param PatientForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo<Boolean> insert(@RequestBody PatientForm PatientForm) {
        return ResultInfo.build(patientIService.insert(PatientForm));
    }

    /**
     * 修改root账户信息
     * @param PatientForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo<Boolean> edit(@RequestBody PatientForm PatientForm) {
        return ResultInfo.build(patientIService.edit(PatientForm));
    }

    /**
     * 查询总数
     * @return ResultInfo
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResultInfo<Long> count() {
        return ResultInfo.build(patientIService.count());
    }
}
