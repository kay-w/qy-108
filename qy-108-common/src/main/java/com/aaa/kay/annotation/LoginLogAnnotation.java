package com.aaa.kay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @MethodName:
 * @Description: 创建自定义注解
 *          实现自定义注解必须要添加两个注解
 *          1 @Target 标识了该注解所使用的位置(是方法 还是类 或者属性)
 *            type 类
 *            METHOD 方法
 *            FIELD 作用于属性
 *          2 @Retention 标识了该注解什么时候生效
 *            RUNTIME 项目运行时生效
 *            TEST 测试阶段生效
 * @Param:
 * @Return:
 * @Author: 59983
 * @Date: 2020/5/28
**/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLogAnnotation {
    /**
     * @MethodName: operationType
     * @Description: 需要执行的操作类型
     *  delete 操作 login 操作 register操作
     * @Param: []
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/28
    **/

    String operationType() default "";

    /**
     * @MethodName: operationName
     * @Description: 要执行的具体操作内容
     *        删除用户操作 删除图书操作
     * @Param: []
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/28
    **/
    String operationName() default "";
}
