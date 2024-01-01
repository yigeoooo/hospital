package com.hospital.modual.login.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.pojo.form.BaseForm;
import com.hospital.common.utils.ResultInfo;
import com.hospital.modual.login.pojo.entity.DoctorEntity;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.pojo.form.DoctorForm;
import com.hospital.modual.login.pojo.form.RootForm;
import com.hospital.modual.login.service.DoctorIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页条件查询
     * @param doctorForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo page(@RequestBody DoctorForm doctorForm) {
        Page<DoctorEntity> page = doctorIService.page(doctorForm);
        return ResultInfo.build(page);
    }

    /**
     * 修改状态
     * @param doctorForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultInfo status(@RequestBody DoctorForm doctorForm) {
        doctorIService.changeStatus(doctorForm);
        return ResultInfo.build(true);
    }

    /**
     * 逻辑删除root账户
     * @param id
     * @return ResultInfo
     */
    @GetMapping("/delete/{id}")
    public ResultInfo delete(@PathVariable("id") String id) {
        boolean bo = doctorIService.deleted(id);
        return ResultInfo.build(bo);
    }

    /**
     * 新增管理员账户
     * @param doctorForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo insert(@RequestBody DoctorForm doctorForm) {
        return ResultInfo.build(doctorIService.insert(doctorForm));
    }

    /**
     * 修改root账户信息
     * @param doctorForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo edit(@RequestBody DoctorForm doctorForm) {
        return ResultInfo.build(doctorIService.edit(doctorForm));
    }

}
