package com.hospital.modual.login.service.impl;

import com.hospital.common.pojo.form.BaseForm;
import com.hospital.modual.login.mapper.LoginMapper;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @since user类service曾接口实现类，主要用于实现接口方法<br>
 * 实现类主要实现接口，拓展代码，实现功能，采用implements关键字，跟上实现接口类类名<br>
 * 注解含义：<br>
 * param 接收得参数<br>
 * return 方法返回值<br>
 */
//@Service注解，将此类交由bean容器管理，在需要的时候注入，表示这是一个service层得类，专门处理逻辑业务代码
//并将此类交由bean容器接管
@Service
public class LoginImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 登陆操作
     * @param baseForm
     * @return boolean
     */
    @Override
    public boolean login(BaseForm baseForm) {
        //调用mapper层方法，验证登录
        Integer count = loginMapper.login(baseForm.getId(), baseForm.getPassword());
        if (count != 0) {
            //如果查询返回不是0，说明存在用户，返回true
            return true;
        }
        //若不存在，查询结果未0，返回false
        return false;
    }
}
