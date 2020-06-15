package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.User;
import com.aaa.kay.service.IQYService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ljz
 * @create: 2020-05-20 21:24
 * @description:
 *      用户管理
 **/
@RestController
@Api(value = "项目管理信息", tags = "项目管理接口")
public class UserController extends BaseController {

    @Autowired
    private IQYService iqyUserService;

    /**
     * @author ljz
     * @description
     *    获取全部用户信息并分页
     * @param: [pageNo, pageSize]
     * @date 2020/5/26
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUserInfo")
    @ApiOperation(value = "查询功能", notes = "查询项目管理信息")
    public ResultData selectUserInfo(Integer pageNo, Integer pageSize){
        PageInfo<User> userPageInfo = iqyUserService.selectUserInfo(pageNo, pageSize);
        if (!"".equals(userPageInfo) && null != userPageInfo){
            return super.selectSuccess(userPageInfo);
        }
        return super.selectFailed();
    }

    /**
     * @author ljz
     * @description
     *    获取单个用户的详细信息
     * @param: [user]
     * @date 2020/5/21
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @PostMapping("/selectInfoById")
    public ResultData selectInfoById(User user){
        User user1 = iqyUserService.selectInfoById(user);
        if (null != user1 && !"".equals(user1)){
            return super.selectSuccess(user1);
        }
        return super.selectFailed();
    }

    /**
     * @author ljz
     * @description
     *    删除用户
     * @param:
     * @date 2020/5/21
     * @return
     * @throws
     **/
    @PostMapping("/deleteUserById")
    public ResultData deleteUserById(@RequestBody User user){
        Boolean aBoolean = iqyUserService.deleteUserById(user);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }
    /**
     * @author ljz
     * @description
     *    添加用户
     * @param: [user]
     * @date 2020/5/22
     * @return java.lang.Boolean
     * @throws
     **/
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody User user){
        Boolean aBoolean = iqyUserService.addUser(user);
        if (aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
    }
    /**
     * @author ljz
     * @description
     *    修改用户信息
     * @param: [user]
     * @date 2020/5/23
     * @return com.aaa.six.base.ResultData
     * @throws 
     **/
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody User user){
        Boolean aBoolean = iqyUserService.updateUser(user);
        if (aBoolean){
            return super.updateSuccess();

        }else {
            return super.updateFailed();
        }
    }
    
    /**
     * @author ljz
     * @description
     *    批量删除
     * @param: [ids]
     * @date 2020/5/23
     * @return com.aaa.six.base.ResultData
     * @throws 
     **/
    @PostMapping("/deleteUserByIds")
    public ResultData deleteUserByIds(@RequestBody List<Object> ids){
        Integer integer = iqyUserService.deleteUserByIds(ids);
        if (integer > 0 ){
            return super.deleteSuccess();
        }else {
            return super.deleteFailed();
        }
    }
    
    /**
     * @author ljz
     * @description
     *    用户条件分页查询
     * @param: [username, deptId, pageNo, pageSize]
     * @date 2020/6/1
     * @return com.aaa.six.base.ResultData
     * @throws 
     **/
    @PostMapping("/selectUserByField")
    public ResultData selectUserByField(@RequestBody User user, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iqyUserService.selectUserByField(user, pageNo, pageSize);
        //判断查询是否成功
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFailed();
    }

    /**
     * @author ljz
     * @description
     *    根据用户性别查询用户信息
     * @param: [ssex, pageNo, pageSize]
     * @date 2020/6/1
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @GetMapping("/selectUserBySsex")
    public ResultData selectUserBySsex(String ssex, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iqyUserService.selectUserBySsex(ssex, pageNo, pageSize);
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFailed();
    }

    /**
     * @author ljz
     * @description
     *    根据状态查询用户信息
     * @param: [status, pageNo, pageSize]
     * @date 2020/6/1
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @GetMapping("/selectUserBySta")
    public ResultData selectUserBySta(String status,Integer pageNo,Integer pageSize){
        PageInfo pageInfo = iqyUserService.selectUserBySta(status, pageNo, pageSize);
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFailed();
    }

    /**
     * @author ljz
     * @description
     *    重置密码
     * @param: [user]
     * @date 2020/6/1
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @PostMapping("/resetUserPwd")
    public ResultData resetUserPwd(@RequestBody User user){
        Integer integer = iqyUserService.resetUserPwd(user);
        if (integer!=null){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
}
