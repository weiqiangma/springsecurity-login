package com.example.springsecuritylogin.controller;

import com.example.springsecuritylogin.entity.UmsAdminPermissionRelation;
import com.example.springsecuritylogin.service.UmsAdminPermissionRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
@RestController
@RequestMapping("umsAdminPermissionRelation")
public class UmsAdminPermissionRelationController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsAdminPermissionRelation selectOne(Long id) {
        return this.umsAdminPermissionRelationService.queryById(id);
    }

}