package com.hospital.model.scheduling.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.scheduling.pojo.entity.SchedulingEntity;
import com.hospital.model.scheduling.pojo.form.SchedulingEditForm;
import com.hospital.model.scheduling.pojo.form.SchedulingListForm;
import com.hospital.model.scheduling.pojo.form.SchedulingSearchForm;
import com.hospital.model.scheduling.service.SchedulingIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 排班表交互层
 * @author psh
 * @since date 2024/1/7
 */
@RestController
@RequestMapping("/saas/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingIService schedulingIService;

    /**
     * 新建排班信息
     * @param schedulingListForm 接参数组
     * @return ResultInfo
     */
    @PostMapping("/topic")
    public ResultInfo<Boolean> insert(@RequestBody SchedulingListForm schedulingListForm) {
        schedulingIService.insert(schedulingListForm);
        return ResultInfo.build(true);
    }

    /**
     * 分页条件查询排班计划(过滤医生姓名)
     * @param schedulingSearchForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/page")
    public ResultInfo<Page<SchedulingEntity>> page(@RequestBody SchedulingSearchForm schedulingSearchForm) {
        return ResultInfo.build(schedulingIService.page(schedulingSearchForm));
    }

    /**
     * 分页条件查询排班计划(不过滤医生姓名)
     * @param schedulingSearchForm 接参对象
     * @return ResultInfo
     */
    @PostMapping("/getPage")
    public ResultInfo<Page<SchedulingEntity>> getPage(@RequestBody SchedulingSearchForm schedulingSearchForm) {
        return ResultInfo.build(schedulingIService.getPage(schedulingSearchForm));
    }

    /**
     * 修改排班计划
     * @param schedulingEditForm 接参对象
     * @return ResultInfo
     */
    @PatchMapping("/edit")
    public ResultInfo<Boolean> edit(@RequestBody SchedulingEditForm schedulingEditForm) {
        schedulingIService.edit(schedulingEditForm);
        return ResultInfo.build(true);
    }

    /**
     * 逻辑删除排班信息
     * @param id id
     * @return ResultInfo
     */
    @DeleteMapping("/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        schedulingIService.removeById(id);
        return ResultInfo.build(true);
    }

}
