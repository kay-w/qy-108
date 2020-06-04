package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.PrincipalMapper;
import com.aaa.kay.model.Principal;
import com.aaa.kay.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PrincipalService
 * @Author Administrator
 * 单位负责人
 * @Date 2020\5\30 0030 21:46
 * @Version 1.0
 **/
@Service
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;
    /**
     * @Author xyg
     * @Date 10:01 2020\5\31 0031
     * 单位负责人 新增数据
     * @Param [principal]
     * @return java.lang.Integer
     **/
    public Integer addPrincipal(Principal principal){
        //获取当前时间
        String currentDate = DateUtils.getCurrentDate();
        System.out.println(currentDate);
        //把当前时间存放到实体中
        principal.setCreateTime(currentDate);
        try {
            Integer add = super.add(principal);
            //判断是否新增成功
            if (add > 0){
                return add;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 10:20 2020\5\31 0031
     * 单条删除
     * @Param [id]
     * @return java.lang.Integer
     **/
    public Integer deletePrincipal(Principal id){
        try {
            Integer delete = super.delete(id);
            if (delete>0){
                return delete;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 17:21 2020\5\31 0031
     * 单位负责人 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    public Integer deletePrincipals(List<Object> ids){
        try {
            Integer integer = super.batchDelete(ids);
            if (integer>0){
                return integer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    /**
     * @Author xyg
     * @Date 18:53 2020\5\31 0031
     * 单位负责人 查询一条数据
     * @Param
     * @return
     **/
    public Principal selectOne1(Principal id){
        try {
            Principal principal = super.queryOne(id);
            //判断是否查询到数据
            if (null != principal){
                return principal;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 20:21 2020\5\31 0031
     * 单位负责人 更新数据
     * @Param [principal]
     * @return java.lang.Integer
     **/
    public Integer updatePrincipal(Principal principal){
        //获取当前时间
        String currentDate = DateUtils.getCurrentDate();
        //存放到实体中
        principal.setModifyTime(currentDate);
        try {
            Integer update = super.update(principal);
            //判断是否为null
            if (update>0){
                return update;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author xyg
     * @Date 21:13 2020\5\31 0031
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.kay.model.Principal>
     **/
    public PageInfo<Principal> selectInfo( Integer pageNo, Integer pageSize){
        try {
            return super.queryListByPage(pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }






}
