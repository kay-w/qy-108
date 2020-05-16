package com.aaa.kay.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @ClassName JSONUtil
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
public class JSONUtil<T> {
    // 定义静态常量ObjectMapper 就是fastjson包进行类型转换的工具类
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    /**
     * @MethodName: toJsonString
     * @Description: 把对象转换为json字符串
     * @Param: [objec]
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/16
    *
     * @param */
    public static String toJsonString (Object object){
        try {
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @MethodName: toObject
     * @Description: 把json对象转换为指定的对象
     *               <T>定义了一个类型
     *               T 返回值的类型
     *
     * @Param: [jsonData,传入的json对象 beanType 所需要转换对象的目标类型]
     * @Return: T
     * @Author: 59983
     * @Date: 2020/5/16
    **/
    public static <T> T toObject(String jsonData,Class<T> beanType){
        try {
            T t=OBJECT_MAPPER.readValue(jsonData,beanType);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @MethodName: toList
     * @Description: json转换为list集合
     * @Param: [jsonData, beanType]
     * @Return: java.util.List<T>
     * @Author: 59983
     * @Date: 2020/5/16
    **/
    public static <T> List<T> toList(String jsonData,Class<T> beanType){
        // 为list添加一个指定的泛型
        // list user.calss 通过contructParametriType方法吧list和user合并 也就是说list指定一个user对象的泛型
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class,beanType);
        try {
            List<T> list =  OBJECT_MAPPER.readValue(jsonData, javaType);
            return list;
        }catch (Exception e ){
            e.printStackTrace();
        }
        return null;
    }

}
