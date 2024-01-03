package com.hospital.modual.login.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.common.utils.ResultInfo;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.pojo.form.RootForm;
import com.hospital.modual.login.service.RootIService;
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
     * @param rootForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultInfo page(@RequestBody RootForm rootForm) {
        Page<UserEntity> page = rootIService.page(rootForm);
        return ResultInfo.build(page);
    }

    /**
     * 修改状态
     * @param rootForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultInfo status(@RequestBody RootForm rootForm) {
        rootIService.changeStatus(rootForm);
        return ResultInfo.build(true);
    }

    /**
     * 逻辑删除root账户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ResultInfo delete(@PathVariable("id") String id) {
        boolean bo = rootIService.deleted(id);
        return ResultInfo.build(bo);
    }

    /**
     * 新增管理员账户
     * @param rootForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultInfo insert(@RequestBody RootForm rootForm) {
        return ResultInfo.build(rootIService.insert(rootForm));
    }

    /**
     * 修改root账户信息
     * @param rootForm
     * @return ResultInfo
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultInfo edit(@RequestBody RootForm rootForm) {
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
