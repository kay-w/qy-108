package com.aaa.kay.controller;

import com.aaa.kay.annotation.LoginLogAnnotation;
import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.User;
import com.aaa.kay.service.IQYService;
import com.aaa.kay.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description:
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@RestController
@Api(value = "登录信息", tags = "用户登录接口")
public class LoginController extends BaseController {

    @Autowired
    private IQYService qyService;

    /**
     * @author hhy
     * @description
     *    执行登录操作
     * @param: [user]
     * @date 2020/5/16 8:23
     * @return com.aaa.six.base.ResultData
     * @throws
     */
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录功能", notes = "用户执行登录功能")
    @LoginLogAnnotation(operationType = "登录操作",operationName = "管理员登录")
    public ResultData doLogin(@RequestBody User user){
        System.out.println("consumer启动");
        System.out.println(user);
        TokenVo tokenVo = qyService.doLogin(user);
        System.out.println(tokenVo);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }
}
