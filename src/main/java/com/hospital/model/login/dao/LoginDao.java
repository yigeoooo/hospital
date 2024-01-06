package com.hospital.model.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @since 登录持久层，专门用于与数据库进行交互，@Mapper指的其是持久层类，专门与数据库交互，并将此类交由bean容器接管
 */
@Mapper
public interface LoginDao {

    //@Param 别名，多个参数接收需要起别名，一般和参数名一样
    //@select 指查询
    @Select("select count(*) from root where root_id = #{rootId} and password = #{password} and status = '1' and is_deleted = '0'")
    Integer login(@Param("rootId") String userId, @Param("password") String password);

}
