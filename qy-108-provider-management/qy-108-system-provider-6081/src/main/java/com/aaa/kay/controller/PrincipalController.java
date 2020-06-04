package com.aaa.kay.controller;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.CommonController;
import com.aaa.kay.model.Principal;
import com.aaa.kay.service.PrincipalService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName PrincipalController
 * @Author Administrator
 * @Date 2020\5\30 0030 22:01
 * @Version 1.0
 **/
@RestController
public class PrincipalController extends CommonController {
    @Autowired
    private PrincipalService principalService;
    @Override
    public BaseService<Principal> getBaseService() {
        return principalService;
    }

    /**
     * @Author xyg
     * @Date 10:03 2020\5\31 0031
     * 单位负责人 新增数据
     * @Param [principal]
     * @return java.lang.Integer
     **/
    @RequestMapping("/addPl")
    public Integer addPl(@RequestBody Principal principal){
        return principalService.addPrincipal(principal);
    }
    /**
     * @Author xyg
     * @Date 13:52 2020\5\31 0031
     * 单位负责人 单条删除
     * @Param [id]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deletePl/{id}")
    public Integer deletePl(@PathVariable("id") Principal id){
        return principalService.deletePrincipal(id);
    }
    /**
     * @Author xyg
     * @Date 17:24 2020\5\31 0031
     * 单位负责人 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deletePls")
    public Integer deletePls(@RequestBody List<Object> ids){
        return principalService.deletePrincipals(ids);
    }

    /**
     * @Author xyg
     * @Date 18:57 2020\5\31 0031
     * 单位负责人 查询一条数据
     * @Param [id]
     * @return com.aaa.kay.model.Principal
     **/
    @RequestMapping("/selectOnePl")
    public Principal selectOnePl(@RequestBody Principal id){
        return principalService.selectOne1(id);
    }
    /**
     * @Author xyg
     * @Date 20:31 2020\5\31 0031
     * 单位负责人 更新数据
     * @Param [principal]
     * @return java.lang.Integer
     **/
    @RequestMapping("/updatePl")
    public Integer updatePl(@RequestBody Principal principal){
        return principalService.updatePrincipal(principal);
    }

    /**
     * @Author xyg
     * @Date 21:45 2020\5\31 0031
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo
     **/
    @RequestMapping("/selectInfoPl")
    public PageInfo<Principal> selectInfoPl(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return principalService.selectInfo(pageNo,pageSize);

    }


}
