package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.model.Menu;
import com.aaa.kay.service.MenuService;
import com.aaa.kay.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * @MethodName: selectMenuByField
     * @Description: 根据条件查看菜单信息
     * @Param: [map]
     * @Return: java.util.List<com.aaa.kay.model.Menu>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("selectMenuByField")
    public List<Menu> selectMenuByField(@RequestBody Menu menu){
        //判断前端是否传值成功
        if (!"".equals(menu) && null !=menu){
            try {
                List<Menu> menus = menuService.selectMenuByField(menu);
                if (!"".equals(menus) && null !=menus){
                    return menus;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @MethodName: selectMenuByPrimaryKey
     * @Description: 根据id查询菜单信息
     * @Param: [menuId]
     * @Return: com.aaa.kay.model.Menu
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByPrimaryKey")
    public Menu selectMenuByPrimaryKey(@RequestParam("menuId") Long menuId){

        try {
            //执行查询方法
            Menu menu = menuService.selectMenuByPrimaryKey(menuId);
            if (null !=menu){
                return menu;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @MethodName: selectMenuByParentId
     * @Description: 遍历查询所有菜单
     * @Param: [parentId]
     * @Return: java.util.List<com.aaa.kay.vo.MenuVo>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByParentId")
    public  List<MenuVo> selectMenuByParentId(@RequestParam("parentId") Object parentId){

        try {
            //调用查询方法
            List<MenuVo> menuVos = menuService.selectMenuByParentId(parentId);
            //判断是否查询成功
            if (null != menuVos){
                return menuVos;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @MethodName: insertMenu
     * @Description:新增菜单
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("insertMenu")
    public Boolean insertMenu(@RequestBody Menu menu){
        try {
            Boolean aBoolean = menuService.insertMenu(menu);
            if (aBoolean){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @MethodName: insertMenuButton
     * @Description: 新增按钮
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("insertMenuButton")
    public Boolean insertMenuButton(@RequestBody Menu menu){

        try {
            //调用service的新增方法
            Boolean aBoolean = menuService.insertMenuButton(menu);
            //判断是否新增成功
            if (aBoolean){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @MethodName: deleteMenuByMenuId
     * @Description: 根据id批量删除
     * @Param: [menuIds]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("deleteMenuByMenuId")
    public Boolean deleteMenuByMenuId(@RequestBody List<Object> menuIds){
        try {
            //调用批量删除的方法
            Boolean aBoolean = menuService.deleteMenuByMenuId(menuIds);
            if (aBoolean){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * @MethodName: updateMenuByPrimaryKey
     * @Description: 根据主键id 进行菜单数据的更新
     * @Param: [menu]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("updateMenuByPrimaryKey")
    public Integer updateMenuByPrimaryKey(@RequestBody Menu menu){
        Integer updateResult = null;
        try {
            //调用修改方法
            updateResult = menuService.updateMenuByPrimaryKey(menu);
            if (updateResult > 0 ){
                return updateResult;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
