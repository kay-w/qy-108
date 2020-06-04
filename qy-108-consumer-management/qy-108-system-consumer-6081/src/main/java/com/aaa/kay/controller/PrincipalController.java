package com.aaa.kay.controller;



import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Principal;
import com.aaa.kay.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/4 0004 10:33
 * @Version:1.0
 * @Description: 单位负责人管理
 */
@RestController
public class PrincipalController extends BaseController {

    @Autowired
    private MappingService iqyPrincipalService;

    /**
     * @Description:
     *             获取单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:34
     * @param userId
     * @Return: com.york.base.ResultData
     **/
    @GetMapping("/queryListPrincipalByUserId")
    public ResultData selectPrincipalInfo(@RequestParam("userId") Long userId) {
        List<Principal> principals = iqyPrincipalService.queryListPrincipalByUserId(userId);
        if (principals.size()>0) {
            return selectSuccess(principals);
        }
        return selectFailed();
    }

    /**
     * @Description:
     *             新增单位负责人
     * @Author: York
     * @Date: 2020/6/4 0004 10:35
     * @param principal
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(Principal principal){
        Boolean aBoolean = iqyPrincipalService.addPrincipal(principal);
        if (aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
    }
    /**
     * @Description:
     *             删除单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:35
     * @param principal
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(Principal principal){
        Boolean aBoolean = iqyPrincipalService.deletePrincipal(principal);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

   /**
    * @Description:
    *            修改单位负责人信息
    * @Author: York
    * @Date: 2020/6/4 0004 10:35
    * @param principal
    * @Return: com.york.base.ResultData
    **/
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(Principal principal){
        Boolean aBoolean = iqyPrincipalService.updatePrincipal(principal);
        if (aBoolean){
            return super.updateSuccess();

        }else {
            return super.updateFailed();
        }
    }
}