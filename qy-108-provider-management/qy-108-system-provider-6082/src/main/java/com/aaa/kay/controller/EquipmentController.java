package com.aaa.kay.controller;


import com.aaa.kay.model.Equipment;
import com.aaa.kay.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:37
 * @Version:1.0
 * @Description: EquipmentController设备的控制层代码
 */
@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * @Description:
     *             mappingUnit与Equipment通过userID绑定,使用userID查询单位的设备信息
     * @Author: York
     * @Date: 2020/6/1 0001 9:28
     * @param userId
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.Equipment>>
     **/
    @GetMapping("queryListEquipmentByUserId")
    public List<Equipment> queryListEquipmentByUserId(@RequestParam(value = "userId", required = true) Long userId){
        try {
            Equipment principal = new Equipment();
            principal.setUserId(userId);
            List<Equipment> principals = equipmentService.queryList(principal);
            if(null!=principals&&principals.size()>0){
                return principals;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description:
     *             $end
     * @Author: York
     * @Date: 2020/6/4 0004 9:35
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addEquipment")
    public Boolean addEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = equipmentService.addEquipment(equipment);
        if (aBoolean){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             删除仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:35
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteEquipment")
    public Boolean deleteEquipment(@RequestBody Equipment equipment){
        boolean b = equipmentService.deleteEquipment(equipment);
        if (b){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *            修改仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:35
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateEquipment")
    public Boolean updateEquipment(@RequestBody Equipment equipment){
        return equipmentService.updateEquipment(equipment);
    }
}
