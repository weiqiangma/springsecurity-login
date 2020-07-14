package com.example.springsecuritylogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan(value = "com.example.springsecuritylogin.dao")
public class SpringsecurityLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityLoginApplication.class, args);
    }

}
