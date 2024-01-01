package com.hospital.modual.login.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 医生登陆表实体类
 * @author psh
 * @since date 2023/12/30
 */
@TableName("doctor")
@Data
public class DoctorEntity {
    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 用户名
     */
    private String doctorId;
    /**
     * 密码
     */
    private String password;

    /**
     * 邏輯刪除標識符
     */
    @TableLogic
    private String isDeleted;

    /**
     * 状态，1开启，0关闭
     */
    private boolean status;
}
