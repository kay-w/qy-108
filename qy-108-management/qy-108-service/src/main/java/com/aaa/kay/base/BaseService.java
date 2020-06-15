package com.aaa.kay.base;
import com.aaa.kay.utils.Map2BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.*;


/**
 * @ClassName BaseService
 * @Description: 通用service 这个泛型指的是实体类
 *            也就是说传递什么样的实体类进来 最终所注入的mapper就是什么类型
 *            此时用得mapper为通用mapper 不是qy-108-mapper
 * @Author 59983
 * @Date 2020/5/12
 * @Version V1.0
 **/
public abstract class BaseService <T> {
    private Class<T> cache = null;// 本地缓存池

    @Autowired
    private Mapper<T> mapper;
    /**
     * @MethodName:
     * @Description: 上面的mapper为了保证安全性  必须要是private 那么他的子类userService就调用不到了
     *               所以需要提供方法个子类用 protected提供给子类调用的
     * @Param: []
     * @Return: org.apache.ibatis.annotations.Mapper
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    protected Mapper getMapper(){return mapper;}
    /**
     * @MethodName: 新增方法
     * @Description:
     * * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public Integer add(T t) throws Exception  {
        return mapper.insertSelective(t);
    }
    /**
     * @MethodName: 通过主键删除数据
     * @Description: TODO
     * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public Integer delete(T t) throws Exception{
        return mapper.deleteByPrimaryKey(t);
    }
    /**
     * @MethodName: 批量删除
     * @Description: 通过主键批量删除
     *               能用java代码来搞定的东西 不用子查询
     *               阿里巴巴不允许超过两张表
     * @Param: [ids]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public Integer batchDelete(List<Object> ids) throws Exception{
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByPrimaryKey(example);
    }
    /**
     * @MethodName: 更新数据
     * @Description:
     * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public Integer update(T t) throws Exception{
        return mapper.updateByPrimaryKeySelective(t);
    }
    /**
     * @MethodName: 批量更新
     * @Description: t: 所要更新的数据(t代表实体类 只能放一个id)
     *               IDS 通过主键来进行更新
     * @Param: [t, ids]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public Integer batchUpdate(T t,Object[] ids) throws Exception{
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }
    /**
     * @MethodName: 查询数据
     * @Description:
     * @Param: [t]
     * @Return: T
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    public T queryOne(T t) throws Exception{
        return mapper.selectOne(t);
    }
    /**
     * @MethodName: 通过制定字段查询一条数据
     * @Description: 有条件的查询
     * @Param: [where, orderByField, fields]
     * @Return: T
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public T queryByfield(Sqls where, String orderByField,String...fields) throws Exception{
        return (T) queryByFieldsBase(null,null,where,orderByField,fields).get(0);
    }
    /**
     * @MethodName: 条件查询集合
     * @Description:
     * @Param: [where, orderByField, fields]
     * @Return: java.util.List<T>
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public List<T> queryListByFields(Sqls where,String orderByField,String... fields) throws Exception{
        return queryByFieldsBase(null,null,where,orderByField,fields);
    }
    /**
     * @MethodName: 条件查询分页
     * @Description:
     * @Param: [pageNo, pageSize, where, orderByFileds, fields]
     * @Return: com.github.pagehelper.PageInfo<T>
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public PageInfo<T> queryListByPageAndFields(Integer pageNo,Integer pageSize,Sqls where,String orderByFileds,String... fields) throws  Exception{
        return new PageInfo<T>(queryByFieldsBase(pageNo,pageSize,where,orderByFileds,fields));
    }
    /**
     * @MethodName: 条件查询
     * @Description: 自定义
     * @Param: [t]
     * @Return: java.util.List<T>
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public List<T> queryList(T t)  throws Exception{
        return mapper.select(t);
    }
    /**
     * @MethodName: 分页查询
     * @Description: t 为 查询条件
     * @Param: [t, pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo<T>
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public PageInfo<T> queryListByPage(T t,Integer pageNo, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo=new PageInfo<T>(select);
        System.out.println("分页条件数据到的数据"+pageInfo);
        return pageInfo;
    }
    /**
     * @MethodName: queryListByPage
     * @Description: 单纯的分页查询
     * @Param: [pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo<T>
     * @Author: 59983
     * @Date: 2020/5/26
    **/
    public PageInfo<T> queryListByPage(Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }
    /**
     * @MethodName: 通过反射获取实例对象
     * @Description:
     * @Param: [map]
     * @Return: T
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    public T newInstance(Map map){
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }
    /**
     * @MethodName: 封装条件查询
     * @Description: 分页查询以及排序查询的通用方法 支持多条件查询
     * @Param: [pageNo, pageSize, where, orderByField, field]
     * @Return: java.util.List<T>
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    private List<T> queryByFieldsBase(Integer  pageNo,Integer pageSize, Sqls where,String orderByField,String... field){
        Example.Builder builder= null;
        if(null == field || field.length==0){
            // 如果没有条件查询， 说明查询的是所有数据
            builder = Example.builder(getTypeArguement());
        }else{
            // 搞定某些字段进行查询
            builder = Example.builder(getTypeArguement()).select(field);
        }
        if (null != where){
            // 是否有条件
            builder = builder.where(where);
        }
        if (null !=orderByField){
            // 排序
            builder = builder.orderByDesc(orderByField);
        }
        Example example = builder.build();
        if (null != pageNo && null!=pageSize){// pageHelper分页插件
            PageHelper.startPage(pageNo,pageSize);
        }
        List list=getMapper().selectByExample(example);
        return list;
    }
    /**
     * @MethodName: 获取子类泛型类型
     * @Description: 获取子类泛型类型
     *
     * @Param: []
     * @Return: java.lang.Class<T>
     * @Author: 59983
     * @Date: 2020/5/12
    **/
    /**
     * @author hhy
     * @description
     *    通过主键批量删除
     *    能用java代码搞定的东西，千万不要上子查询
     *    阿里巴巴代码规约：
     *        如果联查超过两张表，要把联查拆开，放在java代码实现
     *
     * @param: [ids]
     * @date 2020/5/13 9:42
     * @return java.lang.Integer
     * @throws
     */
    public Integer delete(List<Object> ids) throws Exception{
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByExample(example);
    }
    private Class<T> getTypeArguement(){
        if (null == cache){//如果缓存池中为null
            cache =(Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
  
        }
        return cache;
    }
}
