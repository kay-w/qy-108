package com.aaa.kay.controller;



import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.CommonController;
import com.aaa.kay.model.Dept;
import com.aaa.kay.service.DeptService;
import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DeptController
 * @Author Administrator
 * @Date 2020\5\26 0026 16:28
 * @Version 1.0
 **/
@RestController
public class DeptController extends CommonController<Dept> {
    @Autowired
    private DeptService deptService;


    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }
    /**
     * @Author xyg
     * @Date 16:37 2020\5\26 0026
     * 部门管理 查询所有数据
     * @Param []
     * @return java.util.List<com.aaa.kay.model.Dept>
     **/
    @RequestMapping("/dept")
    public List<Dept>selectAllDept(){
        return deptService.selectAllDept();
    }
    /**
     * @Author xyg
     * @Date 19:08 2020\5\28 0028
     * 部门管理 新增数据
     * @Param [dept]
     * @return java.lang.Integer
     **/
    @RequestMapping("/addDept")
    public Integer addDept(@RequestBody Dept dept){
        return addDept(dept);
    }
    /**
     * @Author xyg
     * @Date 9:36 2020\5\29 0029
     * 部门管理 单条删除
     * @Param [deptId]
     * @return java.lang.Integer
     **/
    @RequestMapping("/delete/{deptId}")
    public Integer deleteByPrimaryKey(@PathVariable("deptId") Dept deptId){
        return deleteByPrimaryKey(deptId);
    }
    /**
     * @Author xyg
     * @Date 10:23 2020\5\29 0029
     * 部门管理 批量删除
     * @Param [deptIds]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deletes")
    public Integer deleteDeptByIds(@RequestBody List<Object> deptIds){
        return deptService.batchDeleteDept(deptIds);
    }
    /**
     * @Author xyg
     * @Date 11:19 2020\5\29 0029
     * 部门管理 查询一条数据
     * @Param [deptId]
     * @return com.aaa.kay.model.Dept
     **/
    @RequestMapping("/selectDeptOne")
    public Dept selectDeptOne(@RequestParam Dept deptId){
        return deptService.selectOne(deptId);
    }
    /**
     * @Author xyg
     * @Date 10:20 2020\5\30 0030
     * 部门管理 更新数据
     * @Param [dept]
     * @return java.lang.Integer
     **/
    @RequestMapping("/updateDept")
    public Integer UpdateDept1(@RequestBody Dept dept){
        return deptService.updateDept(dept);

    }


}
