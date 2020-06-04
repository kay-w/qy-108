package com.aaa.kay.controller;



import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.MappingUnit;
import com.aaa.kay.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Author: York
 * @Date: 2020/6/4 0004 10:31
 * @Version:1.0
 * @Description: 系统主页-测绘单位
 */
@RestController
public class MappingUnitController extends BaseController {

    @Autowired
    private MappingService iqyMappingUnitService;
    
    /**
     * @Description:
     *             查询测绘单位名称
     * @Author: York
     * @Date: 2020/6/4 0004 10:39
     * @param map
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingUnit>>
     **/
    @GetMapping("queryListMappingUnitByFiled")
    public ResultData<List<MappingUnit>> queryAllMappingUnitByFiled(@RequestParam Map map){
        // 调用 iqyService 中的 fuzzyUnitName 方法，得到查询结果
        List<MappingUnit> mappingUnits = iqyMappingUnitService.queryListMappingUnitByFiled(map);

        // 判断 结果是否为空
        if (mappingUnits != null) {
            // 说明结果不为空，查询成功，使用系统消息 自定义返回值
            return selectSuccess(mappingUnits);
        }else {
            // 查询失败，返回系统信息
            return selectFailed();
        }

    }

    /**
     * @Description:
     *             查询测绘单位基本信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:39
     * @param userId
     * @Return: com.york.base.ResultData<com.york.model.MappingUnit>
     **/
    @GetMapping("/queryOneMappingUnitByUserId")
    public ResultData<MappingUnit> selectUnitInfoById(@RequestParam("userId") Long userId) {
        // 调用 iqyService 中的 selectUnitInfoById 方法，得到查询结果
        MappingUnit mappingUnit1 = iqyMappingUnitService.selectUnitInfoById(userId);

        // 判断 结果是否为空
        if (null != mappingUnit1) {
            // 说明结果不为空，查询成功，返回系统消息，自定义返回值
            return selectSuccess(mappingUnit1);
        }else {
            // 查询失败，返回系统信息
            return selectFailed();
        }
    }

}
