package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.TechnicistMapper;
import com.aaa.kay.model.Technicist;
import com.aaa.kay.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TechnicistController
 * @Author Administrator
 * 用于技术人员信息的增删改查
 * @Date 2020\6\1 0001 9:24
 * @Version 1.0
 **/
@Service
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;
    /**
     * @Author xyg
     * @Date 13:15 2020\6\1 0001
     * 新增数据
     * @Param [technicist]
     * @return java.lang.Integer
     **/
    public Integer addTechnicist(Technicist technicist){
        //获取当前时间并存实体中
        technicist.setCreateTime(DateUtils.getCurrentDate());
        try {
            Integer add = add(technicist);
            //判断是否新增成功
            if (add>0){
                //成功返回
                return add;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 14:53 2020\6\1 0001
     * 单条删除
     * @Param [id]
     * @return java.lang.Integer
     **/
    public Integer deleteTtKey(Technicist id){
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
     * @Date 16:30 2020\6\1 0001
     * 批量删除
     * @Param [ids]
     * @return java.lang.Integer
     **/
    public Integer delThs(List<Object> ids){
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
     * @Date 18:23 2020\6\1 0001
     * 查询一条数据
     * @Param [id]
     * @return com.aaa.kay.model.Technicist
     **/
    public Technicist selectOneTh(Technicist id){
        try {
            Technicist technicist = super.queryOne(id);
            //判断是否有数据
            if (null != technicist){
                return technicist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
    /**
     * @Author xyg
     * @Date 20:41 2020\6\1 0001
     * 更新数据
     * @Param [technicist]
     * @return java.lang.Integer
     **/
    public Integer updateTh(Technicist technicist){
        //获取当前时间并存进实体
        technicist.setModifyTime(DateUtils.getCurrentDate());
        try {
            Integer update = super.update(technicist);
            //判断是否更新成功
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
     * @Date 20:56 2020\6\1 0001
     * 分页查询
     * @Param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.kay.model.Technicist>
     **/
    public PageInfo<Technicist> queryListByTh(Integer pageNo, Integer pageSize)  {
        try {
            return super.queryListByPage(pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
