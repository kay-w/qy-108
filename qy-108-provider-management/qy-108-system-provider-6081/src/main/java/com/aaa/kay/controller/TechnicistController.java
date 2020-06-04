package com.aaa.kay.controller;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.CommonController;
import com.aaa.kay.model.Technicist;
import com.aaa.kay.service.TechnicistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TechnicistController
 * @Author Administrator
 * 用于技术人员信息的增删改查
 * @Date 2020\6\1 0001 13:22
 * @Version 1.0
 **/
@RestController
public class TechnicistController extends CommonController<Technicist> {
    @Autowired
    private TechnicistService technicistService;
    @Override
    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }
    /**
     * @Author xyg
     * @Date 13:31 2020\6\1 0001
     * 新增数据
     * @Param [technicist]
     * @return java.lang.Integer
     **/
    @RequestMapping("/addTh")
    public Integer addTh(@RequestBody Technicist technicist){
        return technicistService.addTechnicist(technicist);
    }
    /**
     * @Author xyg
     * @Date 15:46 2020\6\1 0001
     * 单条删除
     * @Param [id]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deleteByThKey/{id}")
    public Integer deleteByThKey(@PathVariable("id") Technicist id){
        return technicistService.deleteTtKey(id);
    }

    /**
     * @Author xyg
     * @Date 16:35 2020\6\1 0001
     * 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    @RequestMapping("/batchDelete")
    public Integer batchDelete(@RequestBody List<Object> ids){
        return technicistService.delThs(ids);
    }
    /**
     * @Author xyg
     * @Date 20:23 2020\6\1 0001
     * 查询一条数据
     * @Param [id]
     * @return com.aaa.kay.model.Technicist
     **/
    @RequestMapping("/SelectOne")
    public Technicist SelectOne(@RequestParam("id") Technicist id){
        return technicistService.selectOneTh(id);
    }
    /**
     * @Author xyg
     * @Date 20:43 2020\6\1 0001
     * 更新数据
     * @Param [technicist]
     * @return java.lang.Integer
     **/
    @RequestMapping("/updateThp")
    public Integer updateThp(@RequestBody Technicist technicist){
        return technicistService.updateTh(technicist);
    }
    /**
     * @Author xyg
     * @Date 21:01 2020\6\1 0001
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.kay.model.Technicist>
     **/
    @RequestMapping("/queryListByThp")
    public PageInfo<Technicist> queryListByThp(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return technicistService.queryListByTh(pageNo,pageSize);

    }







}
