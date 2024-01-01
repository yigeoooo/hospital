package com.hospital.modual.login.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author psh
 * @since user实体类，与数据库字段一一对应
 */
//lombok工具提供的注解，提供get，set方法，用于公开对外取值设置的出入口
@Data
@TableName("root")
public class UserEntity {
    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 用户名
     */
    private String rootId;
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
