package com.han.safe.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/*").hasRole("admin")
                .and().formLogin().permitAll();
        //以下这句就可以控制单个用户只能创建一个session，也就只能在服务器登录一次
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }
}

