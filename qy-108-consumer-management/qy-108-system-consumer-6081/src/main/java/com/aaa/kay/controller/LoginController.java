package com.aaa.kay.controller;

import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.User;
import com.aaa.kay.mapper.IQYService;
import com.aaa.kay.vo.TokenVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@RestController
@Api(value = "登录功能",tags = "用户登录接口")
public class LoginController extends BaseController {
    @Autowired
    private IQYService qyService;
    @Autowired
    private ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = qyService.doLogin(user);
        if (tokenVo.getIfSuccess()){
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }
}
