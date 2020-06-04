package com.aaa.kay.controller;


import com.aaa.kay.model.Principal;
import com.aaa.kay.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:33
 * @Version:1.0
 * @Description: PrincipalController法人信息的控制层代码
 */
@RestController
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    /**
     * @Description:
     *             mappingUnit与Principal通过userID绑定,使用userID查询单位的法人信息
     * @Author: York
     * @Date: 2020/6/1 0001 9:25
     * @param userId
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.Principal>>
     **/
    @GetMapping("queryListPrincipalByUserId")
    public List<Principal> queryListPrincipalByUserId(@RequestParam Long userId){
        try {
            Principal principal = new Principal();
            principal.setUserId(userId);
            List<Principal> principals = principalService.queryList(principal);
            if(null!=principals&&principals.size()>0){
                return principals;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description:
     *            新增单位负责人
     * @Author: York
     * @Date: 2020/6/4 0004 9:29
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addPrincipal")
    public Boolean addPrincipal(@RequestBody Principal principal){
        Boolean aBoolean = principalService.addPrincipal(principal);
        if (aBoolean){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             删除单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:30
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deletePrincipal")
    public Boolean deletePrincipal(@RequestBody Principal principal){
        boolean b = principalService.deletePrincipal(principal);
        if (b){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             修改单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:30
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updatePrincipal")
    public Boolean updatePrincipal(@RequestBody Principal principal){
        return principalService.updatePrincipal(principal);
    }

}
