/*
package com.aaa.kay.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

*/
/**
 * @ClassName DynamicDataSource
 * @Description: 重写数据源的路由规则
 * @Author 59983
 * @Date 2020/6/1
 * @Version V1.0
 **//*

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
*/
