package com.example.springsecuritylogin.controller;

import com.example.springsecuritylogin.entity.UmsAdminRoleRelation;
import com.example.springsecuritylogin.service.UmsAdminRoleRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
@RestController
@RequestMapping("umsAdminRoleRelation")
public class UmsAdminRoleRelationController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsAdminRoleRelation selectOne(Long id) {
        return this.umsAdminRoleRelationService.queryById(id);
    }

}