package com.aaa.kay.base;


import static com.aaa.kay.status.Status.*;


/**
 * @ClassName BaseController
 * @Description:通用controller 就是实现consumer和provider统一返回值
 * @Author 59983
 * @Date 2020/5/12
 * @Version V1.0
 **/
public class BaseController {
    /**
     * @MethodName: LoginSuccess
     * @Description: 登录成功 用系统消息
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @MethodName: LoginSuccess
     * @Description: 自定义消息
     * @Param: [msg]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @MethodName: LoginSuccess
     * @Description: 自定义返回数据
     * @Param: [data]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @MethodName: LoginSuccess
     * @Description:  自定义消息 自定义返回数据
     * @Param: [data]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData loginSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @MethodName: loginFailed
     * @Description: 用系统消息
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;

    }
    /**
     * @MethodName: loginFailed
     * @Description: 自定义消息
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData loginFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;

    }
    /**
     * @MethodName: loginFailed
     * @Description: 自定义消息
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData loginFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: loginFailed
     * @Description: 自定义消息和自定义数据
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData loginFailed(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @MethodName: userExist
     * @Description:用户存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }
    /**
     * @MethodName: userExist
     * @Description:用户存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userExist(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @MethodName: userExist
     * @Description:用户存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @MethodName: userExist
     * @Description:用户存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userExist(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @MethodName: userNotExist
     * @Description: 用户不存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;

    }
    /**
     * @MethodName: userNotExist
     * @Description: 用户不存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData userNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;

    }
    /**
     * @MethodName: userNotExist
     * @Description: 用户不存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userNotExist(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: userNotExist
     * @Description: 用户不存在
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userNotExist(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: passwordWrong
     * @Description: 密码错误
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;

    }
    /**
     * @MethodName: passwordWrong
     * @Description: 密码错误
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData passwordWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(msg);
        return resultData;

    }
    /**
     * @MethodName: passwordWrong
     * @Description: 密码错误
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData passwordWrong(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: passwordWrong
     * @Description: 密码错误
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData passwordWrong(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: userLocked
     * @Description: 账号被锁定
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData userLocked(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        return resultData;

    }
    /**
     * @MethodName: userLocked
     * @Description: 账号被锁定
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userLocked(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(msg);
        return resultData;

    }
    /**
     * @MethodName: userLocked
     * @Description: 账号被锁定
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userLocked(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: userLocked
     * @Description: 账号被锁定
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData userLocked(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;

    }
    /**
     * @MethodName: logoutWrong
     * @Description: 账号退出异常
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getCode());
        return  resultData;
    }
    /**
     * @MethodName: logoutWrong
     * @Description: 账号退出异常
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData logoutWrong(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getCode());
        resultData.setData(data);
        return  resultData;
    }
    /**
     * @MethodName: logoutWrong
     * @Description: 账号退出异常
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData logoutWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(msg);
        return  resultData;
    }
    /**
     * @MethodName: logoutWrong
     * @Description: 账号退出异常
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData logoutWrong(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return  resultData;
    }
    /**
     * @MethodName: deleteSuccess
     * @Description: 删除成功
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @MethodName: deleteFailed
     * @Description: 删除失败
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected ResultData deleteFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @MethodName: deleteFailed
     * @Description: 更新成功
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @MethodName: deleteFailed
     * @Description: 更新失败
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @MethodName: deleteFailed
     * @Description: 查询成功
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData querySuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(QUERY_SUCCESS.getCode());
        resultData.setMsg(QUERY_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @MethodName: deleteFailed
     * @Description: 查询失败
     * @Param: []
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected ResultData queryFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(QUERY_FAILED.getCode());
        resultData.setMsg(QUERY_FAILED.getMsg());
        return resultData;
    }

}
