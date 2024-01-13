package com.hospital.model.login.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.model.login.pojo.entity.UserEntity;
import com.hospital.model.login.pojo.form.RootForm;
import com.hospital.model.login.service.RootIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * root账户交互层
 * @author psh
 * @since date 2024/1/1
 */
@RestController
@RequestMapping(("/saas/root"))
public class RootController {

    @Autowired
    private RootIService rootIService;

    /**
     * 分页条件查询
     * @param rootForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo<Page<UserEntity>> page(@RequestBody RootForm rootForm) {
        Page<UserEntity> page = rootIService.page(rootForm);
        return ResultInfo.build(page);
    }

    /**
     * 修改状态
     * @param rootForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultInfo<Boolean> status(@RequestBody RootForm rootForm) {
        rootIService.changeStatus(rootForm);
        return ResultInfo.build(true);
    }

    /**
     * 逻辑删除root账户
     * @param id id
     * @return ResultInfo
     */
    @GetMapping("/delete/{id}")
    public ResultInfo<Boolean> delete(@PathVariable("id") String id) {
        boolean bo = rootIService.deleted(id);
        return ResultInfo.build(bo);
    }

    /**
     * 新增管理员账户
     * @param rootForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo<Boolean> insert(@RequestBody RootForm rootForm) {
        return ResultInfo.build(rootIService.insert(rootForm));
    }

    /**
     * 修改root账户信息
     * @param rootForm 接参对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo<Boolean> edit(@RequestBody RootForm rootForm) {
        return ResultInfo.build(rootIService.edit(rootForm));
    }

    /**
     * 查询总数
     * @return ResultInfo
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResultInfo<Long> count() {
        return ResultInfo.build(rootIService.count());
    }
}
