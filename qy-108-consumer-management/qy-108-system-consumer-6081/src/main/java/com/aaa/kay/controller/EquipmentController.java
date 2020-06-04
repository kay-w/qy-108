package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Equipment;
import com.aaa.kay.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: York
 * @Date: 2020/6/4 0004 9:22
 * @Version:1.0
 * @Description: 仪器设备信息管理
 */
@RestController
public class EquipmentController extends BaseController {
    @Autowired
    private MappingService iqyEquipmentService;

    @Autowired
    private MappingService mappingService;
    /**
     * @Description:
     *             根据userid查询仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:22
     * @param userId
     * @Return: com.york.base.ResultData
     **/
    @GetMapping("/queryListEquipmentByUserId")
    public ResultData queryListEquipmentByUserId(@RequestParam("userId") Long userId) {
        List<Equipment> equipmentList = iqyEquipmentService.queryListEquipmentByUserId(userId);
        if (equipmentList.size()>0) {
            return selectSuccess(equipmentList);
        }
        return selectFailed();
    }

    /**
     * @Description:
     *             新增仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:23
     * @param equipment
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addEquipment")
    public ResultData addEquipment(Equipment equipment){
        Boolean aBoolean = iqyEquipmentService.addEquipment(equipment);
        if (aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
    }

    /**
     * @Description:
     *             删除仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:23
     * @param equipment
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(Equipment equipment){
        Boolean aBoolean = iqyEquipmentService.deleteEquipment(equipment);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * @Description:
     *             修改仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:23
     * @param equipment
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(Equipment equipment){
        Boolean aBoolean = iqyEquipmentService.updateEquipment(equipment);
        if (aBoolean){
            return super.updateSuccess();

        }else {
            return super.updateFailed();
        }
    }
}
