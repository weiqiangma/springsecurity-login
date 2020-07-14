package com.example.springsecuritylogin.controller;

import com.example.springsecuritylogin.entity.UmsRole;
import com.example.springsecuritylogin.service.UmsRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户角色表(UmsRole)表控制层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
@RestController
@RequestMapping("umsRole")
public class UmsRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UmsRoleService umsRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsRole selectOne(Long id) {
        return this.umsRoleService.queryById(id);
    }

}