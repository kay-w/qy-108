package com.aaa.kay.service;


import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.User;
import com.aaa.kay.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/5/17 0017 16:23
 * @Version:1.0
 * @Description: fallbackFactory:就是来实现熔断的，在实际开发中，开发阶段不能去开启熔断,
 *                因为一旦开启了熔断，整个异常都不会再抛出，不方便调bug
 *                 一旦使用feign来进行传递参数的时候，必须要注意两个点:
 *                1.如果是简单类型(8种基本类型，String)--->必须使用注解@RequestParam
 *                  基本类型可以传多个，也就是说一个方法的参数中可以使用多@RequestParam
 *               2.如果传递包装类型(List, Map, Vo, Po)，只能传递一个，而且必须要使用@RequestBody注解
 *           也就是说最终把这些参数值传递到provider项目的controller中，在这provider项目的controller中也必须使用
 *           相同的注解，而且provider和api的方法必须要一模一样(copy是最方便的)
 */
@FeignClient(value = "system-interface")
public interface IQYService {
    /**
     * @Description:
     *             执行登录操作
     * @Author: York
     * @Date: 2020/5/27 0027 21:05
     * @param user
     * @Return: com.york.vo.TokenVo
     **/
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /**
     * @Description:
     *             新增用户信息
     * @Author: York
     * @Date: 2020/5/27 0027 21:04
     * @param user
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addUser")
    Boolean addUser(@RequestBody User user);

    /**
     * @Description:
     *             添加登录日志信息
     * @Author: York
     * @Date: 2020/5/27 0027 21:04
     * @param map
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addLoginLog")
    ResultData addLoginLog(@RequestBody Map map);

    /**
     * @Description:
     *              ftp文件上传
     * @Author: York
     * @Date: 2020/5/29 0029 21:24
     * @param file
     * @Return: java.lang.Boolean
     **/
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(MultipartFile file);
}
