package com.example.springsecuritylogin.entity;

import java.io.Serializable;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
public class UmsAdminPermissionRelation implements Serializable {
    private static final long serialVersionUID = 461137971460138851L;
    
    private Long id;
    
    private Long adminId;
    
    private Long permissionId;
    
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}