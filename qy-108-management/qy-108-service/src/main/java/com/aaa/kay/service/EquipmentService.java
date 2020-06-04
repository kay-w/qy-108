package com.aaa.kay.service;


import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.EquipmentMapper;
import com.aaa.kay.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.aaa.kay.staticstatus.TimeProperties.*;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:35
 * @Version:1.0
 * @Description: EquipmentService设备实现层
 */
@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @Description:
     *             新增仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:40
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    public Boolean addEquipment(Equipment equipment){
        if (null == equipment && "".equals(equipment)){
            return false;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            equipment.setCreateTime(format);
            int insert = equipmentMapper.insert(equipment);
            if (insert > 0){
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * @Description:
     *             删除仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:40
     * @param equipment
     * @Return: boolean
     **/
    public boolean deleteEquipment(Equipment equipment) {
        if ("".equals(equipment) && null == equipment) {
            return false;
        } else {
            int i = equipmentMapper.deleteByPrimaryKey(equipment);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * @Description:
     *             修改仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:40
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    public Boolean updateEquipment(Equipment equipment) {
        //判断user是否为空
        if ("".equals(equipment) && null == equipment) {
            return false;
        } else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            equipment.setCreateTime(format);
            int i = equipmentMapper.updateByPrimaryKey(equipment);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
