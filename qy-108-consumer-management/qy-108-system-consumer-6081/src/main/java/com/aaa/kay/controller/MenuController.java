package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Menu;
import com.aaa.kay.service.IQYService;
import com.aaa.kay.vo.MenuVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "菜单管理" ,tags = "菜单管理接口")
public class MenuController  extends BaseController {

    @Autowired
    private IQYService iqyService;

    /**
     * @MethodName: selectMenuByField
     * @Description: 条件查询
     * @Param: [map]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("selectMenuByField")
    public ResultData selectMenuByField(@RequestBody Map map){
            List<Menu> menus = iqyService.selectMenuByField(map);
            if (null !=menus){
                return querySuccess().setData(menus);

            }
        return queryFailed();
    }

    /**
     * @MethodName: selectMenuByPrimaryKey
     * @Description: 根据id查询菜单信息
     * @Param: [menuId]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByPrimaryKey")
    public ResultData selectMenuByPrimaryKey(@RequestParam Long menuId){
        Menu menu = iqyService.selectMenuByPrimaryKey(menuId);
        if (null !=menu){
            return querySuccess().setData(menu);

        }
        return queryFailed();
    }
    /**
     * @MethodName: selectMenuByParentId
     * @Description: 遍历查询所有菜单信息
     * @Param: [parentId]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @GetMapping("selectMenuByParentId")
    public ResultData selectMenuByParentId(Object parentId){
        List<MenuVo> menuVos = iqyService.selectMenuByParentId(parentId);
        if (menuVos.size()>0){
            return querySuccess().setData(menuVos);

        }
        return queryFailed();
    }

   /**
    * @MethodName: insertMenu
    * @Description: 新增菜单
    * @Param: [menu]
    * @Return: com.aaa.kay.base.ResultData
    * @Author: 59983
    * @Date: 2020/6/4
   **/
    @PostMapping("insertMenu")
    public ResultData insertMenu(@RequestBody Menu menu){
        System.out.println(menu);
        Boolean aBoolean = iqyService.insertMenu(menu);
        if (aBoolean){
            return super.addSuccess();
        }
        return super.addFailed();
    }

    /**
     * @MethodName: insertMenuButton
     * @Description: 新增按钮
     * @Param: [menu]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("insertMenuButton")
    public ResultData insertMenuButton(@RequestBody Menu menu){
        Boolean aBoolean = iqyService.insertMenuButton(menu);
        if (aBoolean){
            return super.addSuccess();
        }
        return super.addFailed();
    }

    /**
     * @MethodName: deleteMenuByMenuId
     * @Description: 根据id批量删除菜单
     * @Param: [menuIds]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("deleteMenuByMenuId")
    public ResultData deleteMenuByMenuId(@RequestBody List<Object> menuIds){
        Boolean aBoolean = iqyService.deleteMenuByMenuId(menuIds);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * @MethodName: updateMenuByPrimaryKey
     * @Description: 根据id修改菜单信息
     * @Param: [menu]
     * @Return: com.aaa.kay.base.ResultData
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    @PostMapping("updateMenuByPrimaryKey")
    public ResultData updateMenuByPrimaryKey( Menu menu){
        Integer integer = iqyService.updateMenuByPrimaryKey(menu);
        if (null !=integer){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
}
