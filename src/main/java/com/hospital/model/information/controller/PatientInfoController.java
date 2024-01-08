package com.hospital.model.information.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.information.pojo.entity.PatientInfoEntity;
import com.hospital.model.information.pojo.form.*;
import com.hospital.model.information.service.PatientInfoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 患者信息交互层
 * @author psh
 * @since date 2024/1/3
 */
@RestController
@RequestMapping("/saas/patientInfo")
public class PatientInfoController {

    @Autowired
    private PatientInfoIService patientInfoIService;


    /**
     * 患者信息分页查询
     * @param patientInfoForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo<Page<PatientInfoEntity>> page(@RequestBody PatientInfoForm patientInfoForm) {
        return ResultInfo.build(patientInfoIService.page(patientInfoForm));
    }

    /**
     * 新增患者
     * @param patientInfoAddForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo<Boolean> insert(@RequestBody PatientInfoAddForm patientInfoAddForm) {
        return ResultInfo.build(patientInfoIService.insert(patientInfoAddForm));
    }

    /**
     * 逻辑删除患者
     * @param id id
     * @return ResultInfo
     */
    @GetMapping("/delete/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        return ResultInfo.build(patientInfoIService.delete(id));
    }

    /**
     * 根据patientI查询详情
     * @param patientId patientId
     * @return ResultInfo
     */
    @GetMapping("/info/{patientId}")
    public ResultInfo<PatientInfoEntity> info(@PathVariable("patientId") String patientId) {
        return ResultInfo.build(patientInfoIService.info(patientId));
    }

    /**
     * 修改患者信息
     * @param patientInfoEditForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo<Boolean> edit(@RequestBody PatientInfoEditForm patientInfoEditForm) {
        return ResultInfo.build(patientInfoIService.edit(patientInfoEditForm));
    }

    /**
     * 查询总数
     * @return ResultInfo
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResultInfo<Long> count() {
        return ResultInfo.build(patientInfoIService.count());
    }

}
