package com.xxj.curriculavariable.conf.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2020/1/10 22:27
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    /**
     * 这里重写了springboot框架中的addResourceHandlers
     * 添加静态拦截地址
     * 同样在application.properties中配置也可以,springboot启动时便会自动读取
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
    }
}
