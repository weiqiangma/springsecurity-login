package com.example.springsecuritylogin.dao;

import com.example.springsecuritylogin.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台用户权限表(UmsPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-13 13:32:33
 */
public interface UmsPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsPermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsPermission 实例对象
     * @return 对象列表
     */
    List<UmsPermission> queryAll(UmsPermission umsPermission);

    /**
     * 新增数据
     *
     * @param umsPermission 实例对象
     * @return 影响行数
     */
    int insert(UmsPermission umsPermission);

    /**
     * 修改数据
     *
     * @param umsPermission 实例对象
     * @return 影响行数
     */
    int update(UmsPermission umsPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}