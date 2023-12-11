package com.demo.pojo.entity;

import lombok.Data;

/**
 * @since user实体类，与数据库字段一一对应
 */
//lombok工具提供的注解，提供get，set方法，用于公开对外取值设置的出入口
@Data
public class UserEntity {
    /**
     * 主键id
     */
    private String id;
    /**
     * 用户名
     */
    private String userId;
    /**
     * 密码
     */
    private String password;
}
