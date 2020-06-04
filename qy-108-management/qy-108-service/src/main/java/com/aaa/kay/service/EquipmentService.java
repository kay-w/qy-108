package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.EquipmentMapper;
import com.aaa.kay.model.Equipment;
import com.aaa.kay.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EquipmentService
 * 仪器信息的增删改查
 * @Author Administrator
 * @Date 2020\6\2 0002 9:03
 * @Version 1.0
 **/
@Service
public class EquipmentService extends BaseService<Equipment> {
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @Author xyg
     * @Date 9:11 2020\6\2 0002
     * 新增数据
     * @Param [equipment]
     * @return java.lang.Integer
     **/
    public Integer addEp(Equipment equipment){
        //判断equipment是否有数据
        if (null == equipment){
           return null;
        }
        //获取当前时间存进实体
        equipment.setCreateTime(DateUtils.getCurrentDate());

        try {
            Integer add = super.add(equipment);
            //判断是否新增成功
            if (add>0){
                return add;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 9:48 2020\6\2 0002
     * @Param [id]
     * 单条删除
     * @return java.lang.Integer
     **/
    public Integer deleteEpOne(Equipment id){
        try {
            Integer delete = super.delete(id);
            //判断是否删除成功
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
     * @Date 10:21 2020\6\2 0002
     * 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    public Integer deleteEps(List<Object> ids){
        try {
            Integer integer = super.batchDelete(ids);
            //判断是否删除成功
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
     * @Date 10:39 2020\6\2 0002
     * 查询一条数据
     * @Param [id]
     * @return com.aaa.kay.model.Equipment
     **/
    public Equipment selectOneEq(Equipment id){
        try {
            Equipment equipment = super.queryOne(id);
            if (null != equipment){
                return equipment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 11:10 2020\6\2 0002
     * 更新数据
     * @Param [equipment]
     * @return java.lang.Integer
     **/
    public Integer updateEp(Equipment equipment){
        //获取当前时间并存进实体
        equipment.setModifyTime(DateUtils.getCurrentDate());
        try {
            Integer update = super.update(equipment);
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
     * @Date 11:16 2020\6\2 0002
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.kay.model.Equipment>
     **/
    public PageInfo<Equipment> queryListByPageEquipment(Integer pageNo, Integer pageSize) {
        try {
            return super.queryListByPage(pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
