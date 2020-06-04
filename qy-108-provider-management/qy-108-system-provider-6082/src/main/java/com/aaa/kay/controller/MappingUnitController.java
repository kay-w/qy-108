package com.aaa.kay.controller;


import com.aaa.kay.model.MappingUnit;
import com.aaa.kay.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/5/31 0031  10:12
 * @Version:1.0
 * @Description: MappingUnitController测绘单位的控制层
 */
@RestController
public class MappingUnitController{

    @Autowired
    private MappingUnitService mappingUnitService;

    /**
     * @Description:
     *             条件查询测绘单位信息,当条件为空时查询所有的信息,这个针对的是主页的搜索查询业务
     * @Author: York
     * @Date: 2020/5/31 0031 16:40
     * @param map
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingUnit>>
     **/
    @GetMapping("queryListMappingUnitByFiled")
    public List<MappingUnit> queryAllMappingUnitByFiled(@RequestParam Map map){
        try {
            MappingUnit mappingUnit = mappingUnitService.newInstance(map);
            List<MappingUnit> mappingUnits = mappingUnitService.queryList(mappingUnit);
            if(null!=mappingUnits&&mappingUnits.size()>0) {
                return mappingUnits;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Description:
     *             用户user表id与unit表的userID绑定，用户通过自己的id去查找unit表的userID获得数据信息
     *
     * @Author: York
     * @Date: 2020/6/1 0001 9:14
     * @param userId
     * @Return: com.york.base.ResultData<com.york.model.MappingUnit>
     **/
    @GetMapping("queryOneMappingUnitByUserId")
    public MappingUnit queryListMappingUnitByUserId(@RequestParam Long userId){
        try {
            MappingUnit unit = new MappingUnit();
            unit.setUserId(userId);
            MappingUnit mappingUnit = mappingUnitService.queryOne(unit);
            if(null!=mappingUnit) {
                return mappingUnit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
