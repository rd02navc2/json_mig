package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebLocalConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 將 /resources/** 映射到 /static/resources/
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/resources/")
                .setCachePeriod(3600); // 可選：快取 1 小時
    }
}
