package com.hospital.model.login.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 患者登录实体类
 * @author psh
 * @since date 2023/12/30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("patient")
public class PatientEntity {

    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 用户名
     */
    private String patientId;
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
