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
     * @Date 19:02 2020\6\4 0004
     * 部门管理 查询所有数据
     * @Param []
     * @return java.util.List<com.aaa.kay.model.Dept>
     **/
    public List<Dept> selectAllDept(){
        List<Dept> depts = deptMapper.selectAll();
        //判断是否查询到数据
        if (null != depts){
            return depts;
        }
        return null;
    }
    /**
     * @Author xyg
     * @Date 20:14 2020\5\26 0026
     *  部门管理 新增数据
     * @Param [dept]
     * @return java.lang.Integer
     **/

    public Integer addDept(Dept dept) {
        // 判断 前端传值是否为空
        if (null == dept || "".equals(dept)) {
            return null;
        }else {
            dept.setCreateTime(DateUtils.getCurrentDate());
            try {
                Integer add = super.add(dept);
                if (add > 0){
                    return add;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
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
            //判断是否删除成功
            if(delete > 0){

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
    public Dept selectOne(Dept dept){

        try {
            Dept deptone = deptMapper.selectOne(dept);
            //判断是否查询到数据
            if (null != deptone){
                return deptone;
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
