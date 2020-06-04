/*
package com.aaa.kay.interceptor;

import com.aaa.kay.annotation.TDS;
import com.aaa.kay.datasource.DynamicDataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @ClassName TDSInterceptor
 * @Author 59983
 * @Date 2020/6/2
 * @Version V1.0
 **//*

@Component
public class TDSInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        TDS annotation = handlerMethod.getMethod().getAnnotation(TDS.class);
        if(null == annotation) {
            annotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(TDS.class);
        }
        if(null != annotation && !"".equals(annotation.value())) {
            DynamicDataSourceContextHolder.setDatasourceType(annotation.value());
        }
        return true;
    }

    }


*/
