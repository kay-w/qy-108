package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Role;
import com.aaa.kay.model.RoleMenu;
import com.aaa.kay.service.IQYService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "角色管理" ,tags = "角色管理接口")
public class RoleController extends BaseController {

    @Autowired
    private IQYService iqyService;

    /**
     * @MethodName: selectAllRole
     * @Description: 查询所有角色信息
     * @Param: [pageNo, pageSize]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectAllRole")
    public ResultData selectAllRole(Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iqyService.selectAllRole(pageNo, pageSize);
        //判断是否查询成功
        if (!"".equals(pageInfo) && null !=pageInfo){
            return querySuccess().setData(pageInfo);

        }
        return queryFailed();
    }


    /**
     * @MethodName: selectRoleByField
     * @Description: 根据条件查询
     * @Param: [map, pageNo, pageSize]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("selectRoleByField")
    public ResultData selectRoleByField(@RequestBody Map map, Integer pageNo,Integer pageSize){
        PageInfo pageInfo = iqyService.selectRoleByField(map, pageNo, pageSize);
        //判断是否查询成功
        if (!"".equals(pageInfo) && null !=pageInfo){
            return querySuccess().setData(pageInfo);

        }
        return queryFailed();
    }

    /**
     * @MethodName: selectRoleByPrimaryKey
     * @Description: 根据主键查询角色信息
     * @Param: [roleId]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectRoleByPrimaryKey")
    public ResultData selectRoleByPrimaryKey(Long roleId){
        Role role = iqyService.selectRoleByPrimaryKey(roleId);
        if (!"".equals(role) && null !=role){
            return querySuccess().setData(role);

        }
        return queryFailed();
    }

    /**
     * @Author:  xj
     * @description
     *      根据角色id查询该角色的权限
     * @Data: 2020/6/1
     * @param [roleId]
     * @Return:com.aaa.xj.base.ResultData
     */
    @GetMapping("selectRoleMenuById")
    public ResultData selectRoleMenuById(Long roleId){
        List<RoleMenu> roleMenus = iqyService.selectRoleMenuById(roleId);
        if (!"".equals(roleMenus) && null !=roleMenus){
            return querySuccess().setData(roleMenus);

        }
        return queryFailed();
    }

    /**
     * @Author:  xj
     * @description
     *      新增角色和对应权限
     * @Data: 2020/6/2
     * @param [map]
     * @Return:com.aaa.xj.base.ResultData
     */
    @PutMapping("/insertRole")
    public ResultData insertRole(@RequestBody Map map){
        Boolean aBoolean = iqyService.insertRole(map);
        if (aBoolean){
            return querySuccess();

        }
        return queryFailed();
    }

    /**
     * @Author:  xj
     * @description
     *      修改角色信息和拥有的权限
     * @Data: 2020/6/2
     * @param [map]
     * @Return:com.aaa.xj.base.ResultData
     */
    @PostMapping("updateRoleByPrimaryKey")
    public ResultData updateRoleByPrimaryKey(@RequestBody Map map){
        Boolean aBoolean = iqyService.updateRoleByPrimaryKey(map);
        if (aBoolean){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }

    /**
     * @Author:  xj
     * @description
     *      根据id批量删除角色和权限
     * @Data: 2020/6/2
     * @param [roleIds]
     * @Return:com.aaa.xj.base.ResultData
     */
    @DeleteMapping("/deleteRoleAndMenu")
    public ResultData deleteRoleAndMenuByRoleId(@RequestBody List<Object> roleIds){
        Boolean aBoolean = iqyService.deleteRoleAndMenuByRoleId(roleIds);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }
}
