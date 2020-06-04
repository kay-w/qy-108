package com.aaa.kay.controller;

import com.aaa.kay.service.LoginService;
import com.aaa.kay.model.User;
import com.aaa.kay.redis.RedisService;
import com.aaa.kay.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName LoginController
 * @Description: 登录操作
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;
    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody User user){
        System.out.println("登录启动");
        return loginService.doLogin(user,redisService);

    }


}
