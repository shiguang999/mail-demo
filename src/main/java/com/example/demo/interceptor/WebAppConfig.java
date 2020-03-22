package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/toLogin")
                .excludePathPatterns("/sendMailMath")
                .excludePathPatterns("/addUser")
                .excludePathPatterns("/login")
                .excludePathPatterns("/mailLogin")
                .excludePathPatterns("/static/**");
    }
}