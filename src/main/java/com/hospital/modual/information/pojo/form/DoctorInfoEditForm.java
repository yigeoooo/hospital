package com.hospital.modual.information.pojo.form;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 医生信息修改form对象
 * @author psh
 * @since date 2024/1/2
 */
@Data
public class DoctorInfoEditForm {

    /**
     * 主键id
     */
    private String id;

    /**
     * 医生登录id
     */
    private String doctorId;

    /**
     * 医生姓名
     */
    private String doctorName;


    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phoneNumber;

}
