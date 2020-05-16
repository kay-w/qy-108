package com.aaa.kay.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommonController
 * @Description: 钩子函数
 * @Author 59983
 * @Date 2020/5/13
 * @Version V1.0
 **/
public abstract class CommonController<T> extends BaseController {
    /**
     * @MethodName: beforeAdd
     * @Description: 钩子函数 新增之前使用
     * @Param: [map]
     * @Return: void
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    protected void beforeAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }
    /**
     * @MethodName: afterAdd
     * @Description: 钩子函数 新增之后使用
     * @Param: [map]
     * @Return: void
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    protected void afterAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }
    public abstract BaseService<T>  getBaseService();
    /**
     * @MethodName: add
     * @Description: 新增数据
     *               之前执行钩子
     *               通过反射获取类对象
     *               执行新增
     *               之后执行钩子
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData add(@RequestBody Map map){

        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            Integer insertResult= getBaseService().add(instance);
            if (insertResult>0){
                // 说明缓存成功
                afterAdd(map);
                return updateSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFailed();
    }
//    TODO delete, batchDelete, update, getOne, getList, getListByPage(不带条件的分页查询)
    /**
     * @MethodName: delete
     * @Description: 删除数据
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData delete(@RequestBody Map map){

        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            Integer insertResult= getBaseService().delete(instance);
            if (insertResult>0){
                // 说明缓存成功
                afterAdd(map);
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }
    /**
     * @MethodName: batchDelete
     * @Description: 批量删除
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData batchDelete(@RequestBody Map map){

        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            Integer insertResult= getBaseService().batchDelete((List<Object>) instance);
            if (insertResult>0){
                // 说明缓存成功
                afterAdd(map);
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }
    /**
     * @MethodName: queryOne
     * @Description: 查询一条数据
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData queryOne(@RequestBody Map map){
        ResultData resultData = new ResultData();
        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            T t = getBaseService().queryOne(instance);
            if (null !=t && "".equals(t)){
                afterAdd(map);
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
    /**
     * @MethodName: queryOne
     * @Description: 查询多条数据
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
     **/
    public ResultData queryList(@RequestBody Map map){
        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            List<T> t = getBaseService().queryList(instance);
            if (t.size()>0){
                afterAdd(map);
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
    /**
     * @MethodName: queryListByPage
     * @Description: 分页查询
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData queryListByPage(@RequestBody Map map){
        beforeAdd(map);
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        T instance=getBaseService().newInstance(map);
        try {
            PageInfo<T> info = getBaseService().queryListByPage(instance,pageNo,pageSize);
            if (null!=info && "".equals(info)){
                afterAdd(map);
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
    /**
     * @MethodName: update
     * @Description: 修改数据
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public ResultData update(@RequestBody Map map){
        beforeAdd(map);
        T instance=getBaseService().newInstance(map);
        try {
            Integer i= getBaseService().update(instance);
            if (i>0){
                afterAdd(map);
                return updateSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFailed();
    }

    /**
     * @MethodName: getservletRequest
     * @Description: 防止数据不安全 所以不能直接在controller某个方法中直接接受HttpServletRequest对象
     *           必须要从本地线程中获取对象
     * @Param: []
     * @Return: javax.servlet.http.HttpServletRequest
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public HttpServletRequest getservletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes){
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
    /**
     * @MethodName: getSession
     * @Description: 获取当前客户端的session对象 如果不存在重新创建一个
     * @Param: []
     * @Return: javax.servlet.http.HttpSession
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public HttpSession getSession(){
        return getservletRequest().getSession();
    }
    /**
     * @MethodName: getExitSession
     * @Description: 获取当前客户端的session对象 如果不存在直接返回null
     * @Param: []
     * @Return: javax.servlet.http.HttpSession
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public HttpSession getExitSession(){
        return getservletRequest().getSession(false);
    }
}
