package com.example.springsecuritylogin.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户角色表(UmsRole)实体类
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
public class UmsRole implements Serializable {
    private static final long serialVersionUID = 842223599780902042L;
    
    private Long id;
    /**
    * 名称
    */
    private String name;
    /**
    * 描述
    */
    private String description;
    /**
    * 后台用户数量
    */
    private Integer adminCount;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 启用状态：0->禁用；1->启用
    */
    private Integer status;
    
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}