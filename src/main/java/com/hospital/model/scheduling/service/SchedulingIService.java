package com.hospital.model.scheduling.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.model.scheduling.pojo.entity.SchedulingEntity;
import com.hospital.model.scheduling.pojo.form.SchedulingEditForm;
import com.hospital.model.scheduling.pojo.form.SchedulingListForm;
import com.hospital.model.scheduling.pojo.form.SchedulingSearchForm;

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
     * 分页条件查询(过滤医生姓名)
     * @param schedulingSearchForm 接参数对象
     * @return Page
     */
    Page<SchedulingEntity> page(SchedulingSearchForm schedulingSearchForm);


    /**
     * 分页条件查询(不过滤医生姓名)
     * @param schedulingSearchForm 接参数对象
     * @return Page
     */
    Page<SchedulingEntity> getPage(SchedulingSearchForm schedulingSearchForm);


    /**
     * 修改排班计划
     * @param schedulingEditForm 参数对象
     */
    void edit(SchedulingEditForm schedulingEditForm);

}
