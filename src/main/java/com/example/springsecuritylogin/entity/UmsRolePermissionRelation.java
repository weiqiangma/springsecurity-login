package com.example.springsecuritylogin.entity;

import java.io.Serializable;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
public class UmsRolePermissionRelation implements Serializable {
    private static final long serialVersionUID = -58140159445253546L;
    
    private Long id;
    
    private Long roleId;
    
    private Long permissionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

}