package com.aaa.kay.controller;

import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Dept;
import com.aaa.kay.service.IQYService;
import com.alibaba.fastjson.parser.JSONToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DeptController
 * @Author Administrator
 * @Date 2020\5\26 0026 16:40
 * @Version 1.0
 **/
@RestController
@Api(value = "部门信息", tags = "部门接口")
public class DeptController extends BaseController {
    @Autowired
    private IQYService iqyService;
    /**
     * @Author xyg
     * @Date 16:59 2020\5\26 0026
     * 部门管理 查询所有数据 返回系统消息
      * @Param []
     * @return com.aaa.kay.base.ResultData
     **/
    @RequestMapping("/dept")
    @ApiOperation(value = "部门信息", notes = "用户执行查询功能")
    public ResultData selectAllDept(){
        List<Dept> depts = iqyService.selectAllDept();
        //判断是否为空
        if (null != depts){
            //返回系统消息
            return querySuccess();
        }
        //返回系统消息
        return queryFailed();
    }
    /**
     * @Author xyg
     * @Date 10:31 2020\5\29 0029
     * 部门管理 新增数据
     * @Param [dept]
     * @return com.aaa.kay.base.ResultData
     **/
    @PutMapping("/addDept")
    @ApiOperation(value = "部门信息", notes = "用户执行新增功能")
    public ResultData addDept(@RequestBody Dept dept){
        Integer dept1 = iqyService.addDept(dept);
        if ( dept1 > 0 ){
            return addSuccess();
        }
        return addFailed();

    }
    /**
     * @Author xyg
     * @Date 10:33 2020\5\29 0029
     * 部门管理 通过主键删除
     * @Param [deptId]
     * @return com.aaa.kay.base.ResultData
     **/
    @RequestMapping("/delete")
    @ApiOperation(value = "部门信息", notes = "用户执行通过主键单条删除功能")
    public ResultData deleteByPrimaryKey(@RequestBody Dept dept){
        Integer delete = iqyService.deleteByPrimaryKey(dept);
        if (delete >0 ){
            return deleteSuccess();
        }
        return deleteFailed();
    }
    /**
     * @Author xyg
     * @Date 10:35 2020\5\29 0029
     * 部门管理 批量删除
     * @Param [deptIds]
     * @return com.aaa.kay.base.ResultData
     **/
    @RequestMapping("/deletes")
    @ApiOperation(value = "部门信息", notes = "用户执行批量删除功能")
    public ResultData deleteDeptByIds(List<Object> deptIds){
        Integer integer = iqyService.deleteDeptByIds(deptIds);
        //判断是否删除成功
        if (integer > 0){
            return deleteSuccess();
        }
        return deleteFailed();
    }
    /**
     * @Author xyg
     * @Date 11:23 2020\5\29 0029
     * 部门管理 查询一条数据返回系统消息
     * @Param [deptId]
     * @return com.aaa.kay.base.ResultData
     **/
    @RequestMapping("/selectDeptOne")
    @ApiOperation(value = "部门信息", notes = "用户执行单条查询功能")
    public ResultData selectDeptOne(@RequestBody Dept dept){
        Dept deptOne = iqyService.selectDeptOne(dept);
        //判断数据dept是否有数据
        if (null != deptOne){
            return querySuccess().setData(deptOne);
        }
        return queryFailed();
    }
    /**
     * @Author xyg
     * @Date 10:24 2020\5\30 0030
     * 部门管理 更新数据返回系统消息
     * @Param [dept]
     * @return com.aaa.kay.base.ResultData
     **/
    @PostMapping("/updateDept")
    @ApiOperation(value = "部门管理", notes = "用户执行更新操作")
    public ResultData UpdateDept1(@RequestBody Dept dept){
        Integer integer = iqyService.UpdateDept1(dept);
        if (integer>0){
            return updateSuccess();
        }
        return updateFailed();
    }
}
