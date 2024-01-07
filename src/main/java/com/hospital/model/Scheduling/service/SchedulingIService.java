package com.hospital.model.Scheduling.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.Scheduling.pojo.entity.SchedulingEntity;
import com.hospital.model.Scheduling.pojo.form.SchedulingEditForm;
import com.hospital.model.Scheduling.pojo.form.SchedulingForm;
import com.hospital.model.Scheduling.pojo.form.SchedulingListForm;
import com.hospital.model.Scheduling.pojo.form.SchedulingSearchForm;

import java.util.List;

/**
 * 排班表服务层接口
 * @author psh
 * @since date 2024/1/7
 */
public interface SchedulingIService extends IService<SchedulingEntity> {

    /**
     * 新增排班
     * @param schedulingListForm 接参数对象
     */
    void insert(SchedulingListForm schedulingListForm);

    /**
     * 分页条件查询
     * @param schedulingSearchForm 接参数对象
     * @return Page
     */
    Page<SchedulingEntity> page(SchedulingSearchForm schedulingSearchForm);

    /**
     * 修改排班计划
     * @param schedulingEditForm 接惨对象
     */
    void edit(SchedulingEditForm schedulingEditForm);

}
