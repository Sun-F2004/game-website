package com.firewin.server.config;

import com.firewin.server.interceptor.JwtTokenAdminInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

//springMvc的相关配置
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    //注册自定义的拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义的拦截器...");

        //需要排除拦截的请求路径
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/user/reg");
        excludePath.add("/user/login");

        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns(excludePath);
    }
}
