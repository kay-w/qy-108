package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.model.Menu;
import com.aaa.kay.model.Role;
import com.aaa.kay.model.RoleMenu;
import com.aaa.kay.service.MenuService;
import com.aaa.kay.service.RoleMenuService;
import com.aaa.kay.service.RoleService;
import com.aaa.kay.utils.GetIPAndTime;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuService menuService;

    /**
     * @MethodName: selectAllRole
     * @Description: 查询所有角色信息
     * @Param: [pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("/selectAllRole")
    public PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = roleService.selectAllARole(pageNo, pageSize);
        if (null !=pageInfo){
            return pageInfo;
        }
        return null;
    }

    /**
     * @MethodName: selectRoleByField
     * @Description: 根据条件查询
     * @Param: [map, pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("/selectRoleByField")
    public PageInfo selectRoleByField(@RequestBody Map map,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = roleService.selectRoleByField(map, pageNo, pageSize);
        if (!"".equals(pageInfo) && null !=pageInfo){
            return pageInfo;
        }
        return null;
    }


    /**
     * @MethodName: selectRoleByPrimaryKey
     * @Description: 根据主键查询角色信息
     * @Param: [roleId]
     * @Return: com.aaa.kay.model.Role
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectRoleByPrimaryKey")
    public Role selectRoleByPrimaryKey(@RequestParam("roleId") Long roleId){
        Role role = roleService.selectRoleByParimaryKey(roleId);
        if (!"".equals(role) && null !=role){
            return role;
        }
        return null;
    }

   /**
    * @MethodName: selectRoleMenuById
    * @Description: 根据角色id查权限
    * @Param: [roleId]
    * @Return: java.util.List<com.aaa.kay.model.RoleMenu>
    * @Author: 59983
    * @Date: 2020/6/4
   **/
    @GetMapping("/selectRoleMenuById")
    public List<RoleMenu> selectRoleMenuById(@RequestParam("roleId") Long roleId){
        List<RoleMenu> roleMenus = roleMenuService.selectRoleMenuById(roleId);
        if (!"".equals(roleMenus) && null !=roleMenus){
            return roleMenus;
        }
        return null;
    }
    /**
     * @MethodName: insertRole
     * @Description: 新增角色和权限
     * @Param: [map]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PutMapping("insertRole")
    public Boolean insertRole(@RequestBody Map map){
        //前台传入map 数据 需要取出后放入实体类中进行添加
        Role role = new Role().setRoleName(map.get("roleName").toString()).setRemark(map.get("remark").toString());
        //此时返回的时 添加生成的主键id
        Long roleId = roleService.insertRole(role);
        System.out.println("角色的主键"+roleId);
        if (null !=roleId){
            Integer insert = 0;
            //获取前台传入的数据 因为map中获取的时object类型 转化为string并且去除空格
            String xx = map.get("remark").toString().replaceAll(" ","");
            System.out.println(xx);
            //将string转化为数组 因string格式为"[1,2,3]" 去除边框[]为"1,2,3" 并且以,为分割转化为数组
            // 便于遍历进行权限表的添加数据
            String[] arr = xx.toString().split(",");
            System.out.println(arr);
            Menu menu = new Menu();
            RoleMenu roleMenu = new RoleMenu();
            Integer integer;
            Long menuid;
            //遍历arr中的权限id 进行权限的添加
            for (int i = 0; i < arr.length ; i++) {
                // 将权限添加到菜单表中
                menu=menu.setMenuName(arr[i]).setParentId((long) 5).setCreateTime(GetIPAndTime.getTime());
                menuid =menuService.insertMenuResultId(menu);
                //添加到角色权限中间表中
                roleMenu=roleMenu.setRoleId(roleId).setMenuId(menuid);
                integer = roleMenuService.insertRoleMenu(roleMenu);
                System.out.println(integer);
                integer+=integer;
            }
            if (insert > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * @MethodName: updateRoleByPrimaryKey
     * @Description: 修改角色和权限
     * @Param: [map]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("updateRoleByPrimaryKey")
    public Boolean updateRoleByPrimaryKey(@RequestBody Map map) throws Exception {
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString()).setRemark(map.get("remark").toString()).setRoleId(Long.valueOf(map.get("roleId").toString()));
        //修改角色信息
        Integer updateRoleByPrimaryKey = roleService.updateRoleByPrimaryKey(role);
        if (updateRoleByPrimaryKey > 0){
            //删除角色对应权限
            Integer deleteMenuByRoleId = roleMenuService.deleteMenuByRoleId(map.get("roleId"));
            if (deleteMenuByRoleId > 0){
                Integer insert = 0;
                //获取前台传入的数据 因为map中获取的时object类型 转化为string并且去除空格
                String xx = map.get("remark").toString().replaceAll(" ","");
                //将string转化为数组 因string格式为"[1,2,3]" 去除边框[]为"1,2,3" 并且以,为分割转化为数组
                // 便于遍历进行权限表的添加数据
                String[] arr = xx.substring(1,xx.length()-1).split(",");
                System.out.println(arr);
                Menu menu = new Menu();
                RoleMenu roleMenu = new RoleMenu();
                Integer integer;
                //遍历arr中的权限id 进行权限的添加
                for (int i = 0; i < arr.length ; i++) {
                    // 将权限添加到菜单表中
                    Long menuid = Long.valueOf(menuService.update(menu.setMenuName(arr[i]).setParentId((long) 5).setCreateTime(GetIPAndTime.getTime()).setType("0")));
                    //添加到角色权限中间表中
                    roleMenu.setRoleId((Long) map.get("roleId")).setMenuId(menuid);
                    integer = roleMenuService.update(roleMenu);
                    integer+=integer;
                }
                if (insert > 0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @MethodName: deleteRoleAndMenuByRoleId
     * @Description: 根据id批量删除角色
     * @Param: [roleIds]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @DeleteMapping("/deleteRoleAndMenu")
    public Boolean deleteRoleAndMenuByRoleId(@RequestBody List<Object> roleIds){
        Boolean aBoolean = roleService.deleteRoleByRoleId(roleIds);
        if (aBoolean){
            Boolean aBoolean1 = roleMenuService.deleteMenuByRoleId(roleIds);
            if (aBoolean1){
                return true;
            }
            return false;
        }
        return false;
    }
}
