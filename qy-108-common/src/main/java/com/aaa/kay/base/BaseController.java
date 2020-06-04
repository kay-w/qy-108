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
    /**
     * @Author xyg
     * @Date 9:38 2020\6\2 0002
     * 新增成功
     * @Param []
     * @return com.aaa.kay.base.ResultData
     **/
    protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author xyg
     * @Date 9:39 2020\6\2 0002
     * 新增失败
     * @Param []
     * @return com.aaa.kay.base.ResultData
     **/
    protected ResultData addFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }
    /**
     * @Description:
     *             添加成功，使用系统消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:13
     * @param
     * @Return: com.york.base.ResultData
     **/
    protected ResultData insertSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:
     *             添加成功，使用自定义消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:13
     * @param msg
     * @Return: com.york.base.ResultData
     **/
    protected ResultData insertSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *            添加失败，使用系统消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:13
     * @param
     * @Return: com.york.base.ResultData
     **/
    protected ResultData insertFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     *             添加失败，使用自定义消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:14
     * @param msg
     * @Return: com.york.base.ResultData
     **/
    protected ResultData insertFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @Description:
     *             查询成功，使用系统消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:
     *             查询成功，使用自定义消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param msg
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *            查询成功，使用系统消息，自定义返回数据
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param data
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description:
     *            查询失败，使用系统消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     *             查询失败，使用自定义消息
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param msg
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *            查询失败，使用系统消息，自定义返回值
     * @Author: York
     * @Date: 2020/6/4 0004 9:16
     * @param data
     * @Return: com.york.base.ResultData
     **/
    protected ResultData selectFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

}
