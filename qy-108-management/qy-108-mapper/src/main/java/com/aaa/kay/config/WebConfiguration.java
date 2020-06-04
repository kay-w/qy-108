/*
package com.aaa.kay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * @ClassName WebConfiguration
 * @Author 59983
 * @Date 2020/6/2
 * @Version V1.0
 **//*

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new TDSInterceptor());
    }
}
*/
