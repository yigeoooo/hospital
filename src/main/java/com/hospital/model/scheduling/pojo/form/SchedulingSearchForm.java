package com.hospital.model.scheduling.pojo.form;

import com.hospital.common.pojo.form.PageForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询接惨对象
 * @author psh
 * @since date 2024/1/7
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulingSearchForm extends PageForm {

    /**
     * 医生姓名
     */
    private String doctorName;
    /**
     * 年月日
     */
    private String date;

    /**
     * 时分秒
     */
    private String time;

}
