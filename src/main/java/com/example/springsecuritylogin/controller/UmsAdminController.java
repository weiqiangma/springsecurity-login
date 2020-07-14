package com.example.springsecuritylogin.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.springsecuritylogin.common.CommonResult;
import com.example.springsecuritylogin.dao.UmsAdminPermissionRelationDao;
import com.example.springsecuritylogin.dao.UmsPermissionDao;
import com.example.springsecuritylogin.entity.UmsAdmin;
import com.example.springsecuritylogin.entity.UmsAdminPermissionRelation;
import com.example.springsecuritylogin.entity.UmsPermission;
import com.example.springsecuritylogin.service.UmsAdminService;
import com.example.springsecuritylogin.service.UmsPermissionService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Permission;
import java.util.HashMap;
import java.util.List;

/**
 * 后台用户表(UmsAdmin)表控制层
 *
 * @author makejava
 * @since 2020-07-13 13:32:32
 */
@RestController
@RequestMapping("umsAdmin")
public class UmsAdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsAdmin selectOne(Long id) {
        return this.umsAdminService.queryById(id);
    }

    /**
     * 登录接口
     * @param umsAdmin
     * @return
     */
    @RequestMapping(value = "login")
    public CommonResult login(UmsAdmin umsAdmin) {
        if(umsAdmin == null) return CommonResult.failed("参数不能为空");
        if(StringUtil.isNullOrEmpty(umsAdmin.getUsername())) return CommonResult.failed("用户名不能为空");
        if(StringUtil.isNullOrEmpty(umsAdmin.getPassword())) return CommonResult.failed("密码不能为空");
        return umsAdminService.getAdminByUserNameAndPassword(umsAdmin);
    }

    /**
     * 获取权限
     * @param adminId
     * @return
     */
    @RequestMapping(value = "permission")
    public CommonResult permission(Long adminId) {
        UmsAdminPermissionRelation adminPermissionRelation = new UmsAdminPermissionRelation();
        adminPermissionRelation.setAdminId(adminId);
        List<UmsPermission> list = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(list);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "editWithPermission")
    public CommonResult editWithPermission(@AuthenticationPrincipal UserDetails userDetails) {
        String userName = ("尊敬的" + userDetails.getUsername() + "欢迎登录");
        return CommonResult.success(userName);
    }
}