package com.aaa.kay.controller;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.CommonController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.LoginLog;
import com.aaa.kay.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName LogController
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/29
 * @Version V1.0
 **/
@RestController
public class LogController extends CommonController<LoginLog> {
    @Autowired
    private LoginLogService loginLogService;
    @Override
    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }

    @PostMapping("/addLoginLog")
    public ResultData addLoginLog(@RequestBody Map map){
        System.out.println("添加登录日志");
        return super.add(map);
    }
}
