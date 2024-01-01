package com.hospital.modual.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.modual.login.mapper.RootMapper;
import com.hospital.modual.login.pojo.entity.UserEntity;
import com.hospital.modual.login.pojo.form.RootForm;
import com.hospital.modual.login.service.RootIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * root账户服务层实现类
 * @author psh
 * @since date 2024/1/1
 */
@Service
public class RootServiceImpl extends ServiceImpl<RootMapper, UserEntity> implements RootIService {

    @Autowired
    private RootMapper rootMapper;

    @Override
    public Page<UserEntity> page(RootForm rootForm) {
        Page page = new Page(rootForm.getPage(), rootForm.getSize());
        QueryWrapper query = new QueryWrapper();
        String id = rootForm.getId();
        String rootId = rootForm.getRootId();
        //参数检验，拼接过滤查询条件
        if (StringUtils.isNotEmpty(id)) {
            query.eq("id", id);
        }
        if (StringUtils.isNotEmpty(rootId)) {
            query.eq("root_id", rootId);
        }
        query.eq("is_deleted", "0");
        Page pages = rootMapper.page(page, query);
        return pages;
    }

    @Override
    public void changeStatus(RootForm rootForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(rootForm.getId());
        userEntity.setStatus(rootForm.isStatus());
        rootMapper.updateById(userEntity);
    }

    @Override
    public boolean deleted(String id) {
        int i = rootMapper.deleteById(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(RootForm rootForm) {
        //验证用户id是否重复
        String rootId = rootForm.getRootId();
        QueryWrapper<UserEntity> query = new QueryWrapper<>();
        query.eq("root_id", rootId);
        Long count = rootMapper.selectCount(query);
        if (count == 0) {
            //不重复则如插入
            UserEntity userEntity = new UserEntity();
            userEntity.setRootId(rootForm.getRootId());
            userEntity.setPassword(rootForm.getPassword());
            userEntity.setStatus(rootForm.isStatus());
            rootMapper.insert(userEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(RootForm rootForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(rootForm.getId());
        userEntity.setRootId(rootForm.getRootId());
        userEntity.setPassword(rootForm.getPassword());
        userEntity.setStatus(rootForm.isStatus());
        int count = rootMapper.updateById(userEntity);
        if (count == 0) {
            return false;
        }
        return true;
    }
}
