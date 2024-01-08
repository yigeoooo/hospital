package com.hospital.model.scheduling.pojo.form;

import lombok.Data;

/**
 * 排班计划编辑接参对象
 * @author psh
 * @since date 2024/1/7
 */
@Data
public class SchedulingEditForm {

    /**
     * 主键
     */
    private String id;
    /**
     * 年月日
     */
    private String date;
    /**
     * 时分秒
     */
    private String time;



}
