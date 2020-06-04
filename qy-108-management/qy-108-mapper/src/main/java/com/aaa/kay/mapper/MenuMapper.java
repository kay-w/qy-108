package com.aaa.kay.mapper;


import com.aaa.kay.model.Menu;
import com.aaa.kay.vo.MenuVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends Mapper<Menu> {

    //条件查询

    List<Menu> selectMenuByField(Map map);

    List<MenuVo> selectMenuByParentId(Object parentId);
    Integer insertMenuResultId(Menu menu);
}