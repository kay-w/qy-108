package com.aaa.kay.controller;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.CommonController;
import com.aaa.kay.model.Equipment;
import com.aaa.kay.service.EquipmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EquipmentController
 * 仪器设备信息管理
 * @Author Administrator
 * @Date 2020\6\2 0002 9:13
 * @Version 1.0
 **/
@RestController
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Override
    public BaseService<Equipment> getBaseService() {
        return equipmentService;
    }
    /**
     * @Author xyg
     * @Date 9:19 2020\6\2 0002
     * 新增数据
     * @Param [equipment]
     * @return java.lang.Integer
     **/
    @RequestMapping("/addEquipment")
    public Integer addEquipment(@RequestBody Equipment equipment){
        return equipmentService.addEp(equipment);
    }
    /**
     * @Author xyg
     * @Date 10:09 2020\6\2 0002
     * 删除单条数据
     * @Param [id]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deleteEquipment/{id}")
    public Integer deleteEquipment(@PathVariable("id") Equipment id){
        return equipmentService.deleteEpOne(id);
    }
    /**
     * @Author xyg
     * @Date 10:22 2020\6\2 0002
     * 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deleteEquipments")
    public Integer deleteEquipments( List<Object> ids){
        return equipmentService.deleteEps(ids);
    }
    /**
     * @Author xyg
     * @Date 11:05 2020\6\2 0002
     * 查询一条数据
     * @Param [id]
     * @return com.aaa.kay.model.Equipment
     **/
    @RequestMapping("/selectOneEquipment")
    public Equipment selectOneEquipment(@RequestParam("id") Equipment id){
        return equipmentService.selectOneEq(id);
    }
    /**
     * @Author xyg
     * @Date 11:11 2020\6\2 0002
     * 更新数据
     * @Param [equipment]
     * @return java.lang.Integer
     **/
    @RequestMapping("/updateEquipment")
    public Integer updateEquipment(@RequestBody Equipment equipment){
        return equipmentService.updateEp(equipment);
    }
    /**
     * @Author xyg
     * @Date 11:24 2020\6\2 0002
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo
     **/
    @RequestMapping("/queryListByPageEp")
    public PageInfo queryListByPageEp(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return equipmentService.queryListByPageEquipment(pageNo,pageSize);
    }

}
