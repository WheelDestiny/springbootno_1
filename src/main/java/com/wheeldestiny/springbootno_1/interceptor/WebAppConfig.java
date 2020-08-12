package com.wheeldestiny.springbootno_1.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//注册拦截器
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //将写好的拦截器配置好，并声明拦截规则
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**");
    }
}
