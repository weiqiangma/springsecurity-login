package com.example.springsecuritylogin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.springsecuritylogin.common.CommonResult;
import com.example.springsecuritylogin.common.ResultCode;
import com.example.springsecuritylogin.dao.UmsAdminPermissionRelationDao;
import com.example.springsecuritylogin.entity.UmsAdmin;
import com.example.springsecuritylogin.dao.UmsAdminDao;
import com.example.springsecuritylogin.entity.UmsAdminPermissionRelation;
import com.example.springsecuritylogin.entity.UmsPermission;
import com.example.springsecuritylogin.service.RedisService;
import com.example.springsecuritylogin.service.UmsAdminService;
import com.example.springsecuritylogin.utils.JwtUtilToken;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户表(UmsAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-07-13 13:32:31
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private UmsAdminDao umsAdminDao;

    @Resource
    private RedisService redisService;

    @Resource
    private JwtUtilToken jwtUtilToken;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private UmsAdminPermissionRelationDao adminPermissionRelationDao;

    Logger logger = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsAdmin queryById(Long id) {
        return this.umsAdminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsAdmin> queryAllByLimit(int offset, int limit) {
        return this.umsAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdmin insert(UmsAdmin umsAdmin) {
        this.umsAdminDao.insert(umsAdmin);
        return umsAdmin;
    }

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdmin update(UmsAdmin umsAdmin) {
        this.umsAdminDao.update(umsAdmin);
        return this.queryById(umsAdmin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsAdminDao.deleteById(id) > 0;
    }

    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    @Override
    public UmsAdmin getAdminByUsername(String userName) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(userName);
        List<UmsAdmin> list = umsAdminDao.queryAll(umsAdmin);
        return list.get(0);
    }

    /**
     * 根据用户名和密码查询
     * @param umsAdmin
     * @return
     */
    public CommonResult getAdminByUserNameAndPassword(UmsAdmin umsAdmin) {
        String token = null;
        Map<String, String> map = new HashMap<>();
        try {
            List<UmsAdmin> list = umsAdminDao.getByUserName(umsAdmin.getUsername());
            if (list.size() == 1) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(umsAdmin.getUsername());
                if (!passwordEncoder.matches(umsAdmin.getPassword(), userDetails.getPassword())) {
                    log.info("用户名或密码不正确");
                    return CommonResult.failed("用户名或密码错误");
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                token = jwtUtilToken.generateToken(userDetails);
                map.put("tokenHead", tokenHead);
                map.put("token", token);
            }
        }catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return CommonResult.success(map);
    }

    /**
     * 根据用户ID查询权限
     * @param adminId
     * @return
     */
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminPermissionRelationDao.getPermissionList(adminId);
    }
}