package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.DeptMapper;
import com.aaa.kay.model.Dept;
import com.aaa.kay.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptService
 * @Author Administrator
 * @Date 2020\5\26 0026 15:36
 * @Version 1.0
 **/
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;
    /**
     * @Author xyg
     * @Date 16:06 2020\5\26 0026
     * 部门管理 查询所有数据
     * @Param []
     * @return java.util.List<com.aaa.kay.model.Dept>
     **/
    public List<Dept> selectAllDept(){
        // 调用查询语句获取数据depts
        List<Dept> depts = deptMapper.selectAll();
        //判断是否获取到数据
        if (depts.size()>0){
            //获取成功 返回数据
            return depts;
        }
        //否则返回null
        return null;
    }
    /**
     * @Author xyg
     * @Date 20:14 2020\5\26 0026
     *  部门管理 新增数据
     * @Param [dept]
     * @return java.lang.Integer
     **/

    public Integer addDept(Dept dept){
            //获取当前时间
            String currentDate = DateUtils.getCurrentDate();
            //判断是否获取成功
            if(currentDate.length()>0){
                //获取到把当前时间存入dept实体
                dept.setCreateTime(currentDate);
            }

        try {

                return super.add(dept);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    /**
     * @Author xyg
     * @Date 9:34 2020\5\29 0029
     * 部门管理 单条删除
     * @Param [deptId]
     * @return java.lang.Integer
     **/
    public Integer deleteByPrimaryKey(Dept deptId){
        try {
            Integer delete = delete(deptId);
            //判断是否为null
            if(delete > 0){
                //不为空返回delete
                return delete;
            }else {
                System.out.println("删除出现异常 未成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 10:13 2020\5\29 0029
     * 部门管理 批量删除
     * @Param [deptIds]
     * @return java.lang.Integer
     **/
    public Integer batchDeleteDept(List<Object> deptIds){
        //判断deptIds有没有值
        if (deptIds.size() > 0){
            try {
                Integer delete = super.batchDelete(deptIds);
                //判断是否删除成功
                if (delete > 0 ){
                    return delete;
                }else {
                    System.out.println("删除出现异常 未成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 10:53 2020\5\29 0029
     * 部门管理 查询一条数据
     * @Param [deptId]
     * @return com.aaa.kay.model.Dept
     **/
    public Dept selectOne(Dept deptId){

        try {
            Dept dept = queryOne(deptId);
            //判断是否查询到数据
            if (null != dept){
                return dept;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * @Author xyg
     * @Date 10:17 2020\5\30 0030
     * 部门管理 更新数据
     * @Param [dept]
     * @return java.lang.Integer
     **/
    public Integer updateDept(Dept dept){
        //获取当前修改时间
        String currentDate = DateUtils.getCurrentDate();
        //存进dept实体
        dept.setModifyTime(currentDate);
        //判断是否为null
        if (null != dept) {
            try {
                Integer update = update(dept);
                if (update>0){
                    return update;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
