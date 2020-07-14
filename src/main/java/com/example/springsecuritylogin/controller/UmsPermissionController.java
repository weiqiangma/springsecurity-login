package com.example.springsecuritylogin.controller;

import com.example.springsecuritylogin.entity.UmsPermission;
import com.example.springsecuritylogin.service.UmsPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户权限表(UmsPermission)表控制层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
@RestController
@RequestMapping("umsPermission")
public class UmsPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private UmsPermissionService umsPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsPermission selectOne(Long id) {
        return this.umsPermissionService.queryById(id);
    }

}