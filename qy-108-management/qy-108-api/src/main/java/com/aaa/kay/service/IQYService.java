package com.aaa.kay.service;


import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.*;
import com.aaa.kay.vo.MenuVo;
import com.aaa.kay.vo.TokenVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/5/17 0017 16:23
 * @Version:1.0
 * @Description: fallbackFactory:就是来实现熔断的，在实际开发中，开发阶段不能去开启熔断,
 *                因为一旦开启了熔断，整个异常都不会再抛出，不方便调bug
 *                 一旦使用feign来进行传递参数的时候，必须要注意两个点:
 *                1.如果是简单类型(8种基本类型，String)--->必须使用注解@RequestParam
 *                  基本类型可以传多个，也就是说一个方法的参数中可以使用多@RequestParam
 *               2.如果传递包装类型(List, Map, Vo, Po)，只能传递一个，而且必须要使用@RequestBody注解
 *           也就是说最终把这些参数值传递到provider项目的controller中，在这provider项目的controller中也必须使用
 *           相同的注解，而且provider和api的方法必须要一模一样(copy是最方便的)
 */
@FeignClient(value = "system-interface")
public interface IQYService {
    /**
     * @Description:
     *             执行登录操作
     * @Author: York
     * @Date: 2020/5/27 0027 21:05
     * @param user
     * @Return: com.york.vo.TokenVo
     **/
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /**
     * @Description:
     *             新增用户信息
     * @Author: York
     * @Date: 2020/5/27 0027 21:04
     * @param user
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addUser")
    Boolean addUser(@RequestBody User user);

    /**
     * @Description:
     *             添加登录日志信息
     * @Author: York
     * @Date: 2020/5/27 0027 21:04
     * @param map
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addLoginLog")
    ResultData addLoginLog(@RequestBody Map map);

    /**
     * @Description:
     *              ftp文件上传
     * @Author: York
     * @Date: 2020/5/29 0029 21:24
     * @param file
     * @Return: java.lang.Boolean
     **/
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(MultipartFile file);


    /**
     * @MethodName: selectAllRole
     * @Description: 查询所有角色信息
     * @Param: [pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("/selectAllRole")
    PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @MethodName: selectRoleByField
     * @Description: 根据条件查询
     * @Param: [map, pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("/selectRoleByField")
    PageInfo selectRoleByField(@RequestBody Map map,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);


    /**
     * @MethodName: selectRoleByPrimaryKey
     * @Description: 根据主键查询角色信息
     * @Param: [roleId]
     * @Return: Role
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectRoleByPrimaryKey")
    Role selectRoleByPrimaryKey(@RequestParam("roleId") Long roleId);

    /**
     * @MethodName: selectRoleMenuById
     * @Description: 根据角色id查询拥有的权限
     * @Param: [roleId]
     * @Return: java.util.List<com.aaa.kay.model.RoleMenu>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("/selectRoleMenuById")
    List<RoleMenu> selectRoleMenuById(@RequestParam("roleId") Long roleId);

    /**
     * @MethodName: insertRole
     * @Description: 新增角色和权限
     * @Param: [map]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PutMapping("insertRole")
    Boolean insertRole(@RequestBody Map map);


    /**
     * @MethodName: updateRoleByPrimaryKey
     * @Description: 修改角色和权限
     * @Param: [map]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("updateRoleByPrimaryKey")
    Boolean updateRoleByPrimaryKey(@RequestBody Map map);

    /**
     * @MethodName: deleteRoleAndMenuByRoleId
     * @Description: 通过id飘零删除和修改角色和权限
     * @Param: [roleIds]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @DeleteMapping("/deleteRoleAndMenu")
    Boolean deleteRoleAndMenuByRoleId(@RequestBody List<Object> roleIds);

    /**
     * @MethodName: selectMenuByField
     * @Description: 根据条件查询菜单信息
     * @Param: [map]
     * @Return: java.util.List<com.aaa.kay.model.Menu>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("selectMenuByField")
    List<Menu> selectMenuByField(@RequestBody Map map);

    /**
     * @MethodName: selectMenuByPrimaryKey
     * @Description: 根据主键查询菜单信息
     * @Param: [menuId]
     * @Return: com.aaa.kay.model.Menu
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByPrimaryKey")
    Menu selectMenuByPrimaryKey(@RequestParam("menuId") Long menuId);

    /**
     * @MethodName: selectMenuByParentId
     * @Description: 遍历查询所有菜单信息
     * @Param: [parentId]
     * @Return: java.util.List<com.aaa.kay.vo.MenuVo>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByParentId")
    List<MenuVo> selectMenuByParentId(@RequestParam("parentId") Object parentId);

    /**
     * @MethodName: insertMenu
     * @Description: 新增菜单
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("insertMenu")
    Boolean insertMenu(@RequestBody Menu menu);


    /**
     * @MethodName: insertMenuButton
     * @Description: 新增按钮
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("insertMenuButton")
    Boolean insertMenuButton(@RequestBody Menu menu);

    /**
     * @MethodName: deleteMenuByMenuId
     * @Description: 根据id批量删除菜单
     * @Param: [menuIds]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("deleteMenuByMenuId")
    Boolean deleteMenuByMenuId(@RequestBody List<Object> menuIds);


    /**
     * @MethodName: updateMenuByPrimaryKey
     * @Description: 根据主键id 更新菜单信息
     * @Param: [menu]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("updateMenuByPrimaryKey")
    Integer updateMenuByPrimaryKey(@RequestBody Menu menu);
    /**
     * @Author xyg
     * @Date 22:59 2020\6\4 0004
     * 根据 项目id查询 附件材料
     * @Param [id]
     * @return java.util.List<com.aaa.kay.model.Resource>
     **/
    @GetMapping("selectResourceByRefBizId")
    List<Resource> selectResourceByRefBizId(@RequestParam("id") Object id);

    /**
     * @Author xyg
     * @Date 22:59 2020\6\4 0004
     * 添加新的附件信息
     * @Param [resource]
     * @return java.lang.Integer
     **/
    @PutMapping("insertResource")
    Integer insertResource(@RequestBody Resource resource);
    /**
     * @Author xyg
     * @Date 16:39 2020\5\26 0026
     * 这是部门管理查询所有数据的接口
     * @Param []
     * @return java.util.List<com.aaa.kay.model.Dept>
     **/
    @RequestMapping("/dept")
    List<Dept> selectAllDept();
    /**
     * @Author xyg
     * @Date 20:49 2020\5\28 0028
     * 部门管理新增接口
     * @Param [dept]
     * @return java.lang.Integer
     **/
    @PutMapping("/addDept")
    Integer addDept(@RequestBody Dept dept);
    /**
     * @Author xyg
     * @Date 9:48 2020\5\29 0029
     * 部门管理 单挑删除 通过主键
     * @Param [deptId]
     * @return java.lang.Integer
     **/
    @RequestMapping("/delete")
    Integer deleteByPrimaryKey(@RequestBody Dept dept);
    /**
     * @Author xyg
     * @Date 10:31 2020\5\29 0029
     * 部门管理 批量删除
     * @Param [deptIds]
     * @return java.lang.Integer
     **/
    @RequestMapping("/deletes")
    Integer deleteDeptByIds(@RequestBody List<Object> deptIds);
    /**
     * @Author xyg
     * @Date 11:20 2020\5\29 0029
     * 部门管理 查询一条数据接口
     * @Param [deptId]
     * @return com.aaa.kay.model.Dept
     **/
    @RequestMapping("/selectDeptOne")
    Dept selectDeptOne(@RequestBody Dept dept);
    /**
     * @Author xyg
     * @Date 10:21 2020\5\30 0030
     * 部门管理 更新数据
     * @Param [dept]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateDept")
    Integer UpdateDept1(@RequestBody Dept dept);



}
