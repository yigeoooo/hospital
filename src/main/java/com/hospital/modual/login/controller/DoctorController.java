package com.hospital.modual.login.controller;

import com.hospital.common.pojo.form.BaseForm;
import com.hospital.common.utils.ResultInfo;
import com.hospital.modual.login.service.DoctorIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医生登录交互层
 * @author psh
 * @since date 2023/12/30
 */
@RestController
@RequestMapping("/saas/doctor")
public class DoctorController {

    @Autowired
    private DoctorIService doctorIService;

    /**
     * 医生登录接口
     * @param baseForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultInfo login(@RequestBody BaseForm baseForm) {
        return ResultInfo.build(doctorIService.doctorLogin(baseForm));
    }

}
