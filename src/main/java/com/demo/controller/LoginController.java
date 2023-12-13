package com.demo.controller;

import com.demo.pojo.entity.UserEntity;
import com.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @since 登录Controller层，负责处理登录推出等相关操作
 */
@RestController
@RequestMapping("/saas")
@Slf4j
//@Slf4j,日志注解，提供日志api
//@RestController，交互层注解，说明此类专门用于与前端交互
//@RequestMapping，访问类路径，组成访问路径一部分
public class LoginController {
    //Controller层，主要用与与前端交互，前端通过接口地址访问controller层对应接口，提供服务与资源
    //get，post请求区别在于，get请求更快，但参数拼接在url地址上，访问用户可以看见不安全，
    //post请求，参数会放在请求体中，相对安全

    //依赖注入，将注入到bean容器得类取出使用，如下面LoginService类，是服务层得接口类
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口，前端根据接口地址访问，方法为POST
     * @return
     */
    //@RequestMapping,映射路径，/login是方法路径，method指访问方法，如get方法，post方法等
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody UserEntity userEntity) {
        //@RequestBody,专门用于post请求，将前端传递的值封装成UserEntity对象，注意前端传值得属性必须要和
        //UserEntity得属性名一摸一样，否咋无法接收到值
        log.info("入参：{}", userEntity);
        boolean bo = loginService.login(userEntity);
        //返回给前端判断值
        return bo;
    }
    //测试镜像1.0.0
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
