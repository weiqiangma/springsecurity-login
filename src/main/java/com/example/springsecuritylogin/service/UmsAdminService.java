package com.example.springsecuritylogin.service;

import com.example.springsecuritylogin.common.CommonResult;
import com.example.springsecuritylogin.entity.UmsAdmin;
import com.example.springsecuritylogin.entity.UmsAdminPermissionRelation;
import com.example.springsecuritylogin.entity.UmsPermission;

import java.util.List;

/**
 * 后台用户表(UmsAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-07-13 13:32:31
 */
public interface UmsAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdmin queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsAdmin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    UmsAdmin insert(UmsAdmin umsAdmin);

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    UmsAdmin update(UmsAdmin umsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    UmsAdmin getAdminByUsername(String userName);

    /**
     * 根据用户名和密码查询
     * @param umsAdmin
     * @return
     */
    CommonResult getAdminByUserNameAndPassword(UmsAdmin umsAdmin);

    /**
     * 根据用户ID查询权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);

}