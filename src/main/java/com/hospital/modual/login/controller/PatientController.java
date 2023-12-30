package com.hospital.modual.login.controller;

import com.hospital.common.pojo.form.BaseForm;
import com.hospital.common.utils.ResultInfo;
import com.hospital.modual.login.service.PatientIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultInfo login(@RequestBody BaseForm baseForm) {
        return ResultInfo.build(patientIService.login(baseForm));
    }
}
