package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.MenuMapper;
import com.aaa.kay.model.Menu;
import com.aaa.kay.utils.DateUtils;
import com.aaa.kay.vo.MenuVo;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.aaa.kay.staticstatus.MenuTyoeProperties.*;

@Service
public class MenuService extends BaseService<Menu> {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @MethodName: selectMenuByField
     * @Description: 根据条件查询菜单信息
     * @Param: [map]
     * @Return: java.util.List<com.aaa.kay.model.Menu>
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public List<Menu> selectMenuByField(Menu menu){
        //判断前段是否传值成功
        if (!"".equals(menu) && null !=menu){
            try {
                //调用条件查询方法
                List<Menu> menus =queryList(menu);
                //判断是否查询成功
                if (menus.size()>0 && null !=menus){
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
     * @Description: 根据主键id查询具体菜单数据
     * @Param: [menuId]
     * @Return: com.aaa.kay.model.Menu
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public Menu selectMenuByPrimaryKey(Long menuId){
        //判断menuId是否传递成功
        if (null !=menuId){
            //执行查询
            Menu menu = menuMapper.selectByPrimaryKey(menuId);
            //判断是否查询出值
            if (null !=menu){
                return menu;
            }
            return null;
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
    public List<MenuVo> selectMenuByParentId(Object parentId){
        //第一次查询传入的id为0 则为查询所有的菜单表
        List<MenuVo> menuVos = menuMapper.selectMenuByParentId(parentId);
        if (null != menuVos && menuVos.size() > 0){
            //循环遍历第一次查询的集合
            for (MenuVo menuVO : menuVos) {
                //以本身的MenuId为参数  进行查询本身的子菜单
                Object id1 = menuVO.getMenuId();
                //循环查询 直到本身菜单不在存在子菜单
                List<MenuVo> menuVos1 = this.selectMenuByParentId(id1);
                //添加到父级菜单的集合中 进行数据的返回
                menuVO.setChildrenList(menuVos1);
            }
            return menuVos;
        }
        return null;
    }


    /**
     * @MethodName: insertMenu
     * @Description: 新增菜单
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public Boolean insertMenu(Menu menu){
        //获取当前时间 放入menu中
        menu.setCreateTime(DateUtils.getCurrentDate())
                //将菜单默认type值0传入
                .setType(MENU_TYPE_CAIDAN);

        try {
            //调用新增方法
            int insert =  menuMapper.insert(menu);
            //判断受影响的行数
            if (insert>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @MethodName: insertMenu
     * @Description: 新增菜单 返回主键
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
     **/
    public Long insertMenuResultId(Menu menu){
        //获取当前时间 放入menu中
        menu.setCreateTime(DateUtils.getCurrentDate())
                //将菜单默认type值0传入
                .setType(MENU_TYPE_CAIDAN);
        try {
            //调用新增方法
            Integer i = menuMapper.insertMenuResultId(menu);
            System.out.println("受影响行数"+1);
            //判断受影响的行数
            if (i>0){
                @NotNull Long menuId = menu.getMenuId();
                System.out.println("menuId为"+menuId);
                return menuId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Long.valueOf(-1);
    }

    /**
     * @MethodName: insertMenuButton
     * @Description: 新增按钮
     * @Param: [menu]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public Boolean insertMenuButton(Menu menu){
        //将时间和按钮默认类型传入
        menu.setCreateTime(DateUtils.getCurrentDate())
                .setType(MENU_TYPE_ANNIU);
        try {
            //执行新增方法
            int insert = menuMapper.insert(menu);
            if (insert>0){
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
     * @Description: 根据主键id批量删除菜单数据
     * @Param: [menuIds]
     * @Return: java.lang.Boolean
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public Boolean deleteMenuByMenuId(List<Object> menuIds){

        if (!"".equals(menuIds) && null !=menuIds){
            try {
                //调用父类重载的批量删除方法
                Integer integer = super.batchDelete(menuIds);
                if (integer>0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    /**
     * @MethodName: updateMenuByPrimaryKey
     * @Description: 根据主键id 更新菜单信息
     * @Param: [menu]
     * @Return: java.lang.Integer
     * @Author: 59983
     * @Date: 2020/6/4
    **/
    public Integer updateMenuByPrimaryKey(Menu menu){
        if (null != menu){
            //更新时传入当前时间 更新数据
            menu.setModifyTime(DateUtils.getCurrentDate())
                    .setCreateTime(DateUtils.getCurrentDate());

            int updateResult = menuMapper.updateByPrimaryKey(menu);
            if (updateResult  > 0){
                return updateResult;
            }
        }
        return null;
    }

}
