package com.example.springsecuritylogin.dao;

import com.example.springsecuritylogin.entity.UmsAdminPermissionRelation;
import com.example.springsecuritylogin.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
public interface UmsAdminPermissionRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdminPermissionRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsAdminPermissionRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsAdminPermissionRelation 实例对象
     * @return 对象列表
     */
    List<UmsAdminPermissionRelation> queryAll(UmsAdminPermissionRelation umsAdminPermissionRelation);

    /**
     * 新增数据
     *
     * @param umsAdminPermissionRelation 实例对象
     * @return 影响行数
     */
    int insert(UmsAdminPermissionRelation umsAdminPermissionRelation);

    /**
     * 修改数据
     *
     * @param umsAdminPermissionRelation 实例对象
     * @return 影响行数
     */
    int update(UmsAdminPermissionRelation umsAdminPermissionRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据角色ID获取权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param(value = "adminId")Long adminId);

}