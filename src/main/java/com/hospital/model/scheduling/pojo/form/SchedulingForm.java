package com.hospital.model.scheduling.pojo.form;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


/**
* 排班表接参数类
* @author psh
*/
@Data
@Builder
public class SchedulingForm implements Serializable {


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
    /**
    * 可挂号数量
    */
    private Long count;





}
