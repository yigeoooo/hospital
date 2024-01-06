package com.hospital.model.login.service;

import com.hospital.common.pojo.form.BaseForm;

/**
 * user类service曾接口
 * 接口只能放抽象方法，被其他类实现，主要用于规范代码
 */
public interface LoginService {

    boolean login(BaseForm baseForm);
}
