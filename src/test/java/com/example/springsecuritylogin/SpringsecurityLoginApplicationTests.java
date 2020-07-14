package com.example.springsecuritylogin;

import com.example.springsecuritylogin.entity.UmsAdmin;
import com.example.springsecuritylogin.service.UmsAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SpringsecurityLoginApplicationTests {

    @Resource
    UmsAdminService umsAdminService;
    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("allen");
        umsAdmin.setPassword("123456");
    }

    @Test
    void testUtils() {
        String password = "123456";
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(password);
        System.err.println(encodePassword);

    }

}
