package com.hospital.model.information.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.information.pojo.entity.DoctorInfoEntity;
import com.hospital.model.information.pojo.form.DoctorInfoAddForm;
import com.hospital.model.information.pojo.form.DoctorInfoEditForm;
import com.hospital.model.information.pojo.form.DoctorInfoForm;
import com.hospital.model.information.service.DoctorInfoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医生信息交互层
 * @author psh
 * @since date 2024/1/2
 */
@RestController
@RequestMapping("/saas/doctorInfo")
public class DoctorInfoController {

    @Autowired
    private DoctorInfoIService doctorInfoIService;

    /**
     * 医生信息分页查询
     * @param doctorInfoForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo<Page<DoctorInfoEntity>> page(@RequestBody DoctorInfoForm doctorInfoForm) {
        return ResultInfo.build(doctorInfoIService.page(doctorInfoForm));
    }

    /**
     * 新增医生
     * @param doctorInfoAddForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo<Boolean> insert(@RequestBody DoctorInfoAddForm doctorInfoAddForm) {
        return ResultInfo.build(doctorInfoIService.insert(doctorInfoAddForm));
    }

    /**
     * 逻辑删除医生
     * @param id
     * @return ResultInfo
     */
    @GetMapping("/delete/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        return ResultInfo.build(doctorInfoIService.delete(id));
    }

    /**
     * 修改医生信息
     * @param doctorInfoEditForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo<Boolean> edit(@RequestBody DoctorInfoEditForm doctorInfoEditForm) {
        return ResultInfo.build(doctorInfoIService.edit(doctorInfoEditForm));
    }

    /**
     * 查询总数
     * @return ResultInfo
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResultInfo<Long> count() {
        return ResultInfo.build(doctorInfoIService.count());
    }

}
