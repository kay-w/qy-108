package com.aaa.kay.service;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.*;
import com.github.pagehelper.PageInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/6/4 0004  11:04
 * @Version:1.0
 * @Description: MappingService
 */
@FeignClient(value = "mapping-interface")
public interface MappingService {

    /**
     * @Description:
     *             根据userid查询特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:59
     * @param userId
     * @Return: java.util.List<com.york.model.SpecialPost>
     **/
    @GetMapping("queryListSpecialPostByUserId")
    public List<SpecialPost> queryListSpecialPostByUserId(@RequestParam("userId") Long userId);

    /**
     * @Description:
     *            新增特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:00
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addSpecialPost")
    Boolean addSpecialPost(@RequestBody SpecialPost specialPost);

    /**
     * @Description:
     *             删除特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:00
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteSpecialPost")
    Boolean deleteSpecialPost(@RequestBody SpecialPost specialPost);

    /**
     * @Description:
     *            修改特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:00
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateSpecialPost")
    Boolean updateSpecialPost(@RequestBody SpecialPost specialPost);





    /**
     * @Description:
     *             根据userId查询技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:07
     * @param userId
     * @Return: java.util.List<Technicist>
     **/
    @PostMapping("/selectTechnicistInfo")
    List<Technicist> selectTechnicistInfo(@RequestParam("userId") Long userId);

    /**
     * @Description:
     *             新增技术人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:07
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addTechnicist")
    Boolean addTechnicist(@RequestBody Technicist technicist);

    /**
     * @Description:
     *             删除技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:08
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteTechnicist")
    Boolean deleteTechnicist(@RequestBody Technicist technicist);

    /**
     * @Description:
     *              修改单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:08
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateTechnicist")
    Boolean updateTechnicist(@RequestBody Technicist technicist);






    /**
     * @Description:
     *              mappingUnit与Principal通过userID绑定,使用userID查询单位的法人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:57
     * @param userId
     * @Return: java.util.List<com.york.model.Principal>
     **/
    @GetMapping("queryListPrincipalByUserId")
    public List<Principal> queryListPrincipalByUserId(@RequestParam("userId") Long userId);

    /**
     * @Description:
     *             新增单位负责人
     * @Author: York
     * @Date: 2020/6/4 0004 9:02
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addPrincipal")
    Boolean addPrincipal(@RequestBody Principal principal);

    /**
     * @Description:
     *             删除单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:02
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deletePrincipal")
    Boolean deletePrincipal(@RequestBody Principal principal);

    /**
     * @Description:
     *             修改单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:03
     * @param principal
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updatePrincipal")
    Boolean updatePrincipal(@RequestBody Principal principal);

    /**
     * @Description:
     *             条件查询测绘单位信息,当条件为空时查询所有的信息,这个针对的是主页的搜索查询业务
     * @Author: York
     * @Date: 2020/5/31 0031 16:40
     * @param map
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingUnit>>
     **/
    @GetMapping("queryListMappingUnitByFiled")
    List<MappingUnit> queryListMappingUnitByFiled(@RequestParam Map map);

    /**
     * @Description:
     *             查询测绘单位基本信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:05
     * @param id
     * @Return: com.york.model.MappingUnit
     **/
    @GetMapping("/queryOneMappingUnitByUserId")
    MappingUnit selectUnitInfoById(@RequestParam("userId") Long userId);





    /**
     * @Description:
     *             条件查找所有的测绘项目信息，当条件为空时查询所有的信息,这个针对的是主页的搜索查询业务
     * @Author: York
     * @Date: 2020/5/31 0031 10:34
     * @param
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingProject>>
     **/
    @GetMapping("queryListMappingProjectByFiled")
    public ResultData<List<MappingProject>> queryListMappingProjectByFiled(@RequestParam Map map);

    /**
     * @Description:
     *             根据单位用户编号查询数据信息，这个是mappingUnit与mappingProject关联查询要用到userID
     * @Author: York
     * @Date: 2020/5/31 0031 18:31
     * @param userId
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingProject>>
     **/
    @GetMapping("queryListMappingProjectByUserId")
    public List<MappingProject> queryListMappingProjectByUserId(@RequestParam("userId") Long userId);

    /**
     * @Description:
     *             项目管理 新增方法 单个新增
     * @Author: York
     * @Date: 2020/6/4 0004 8:57
     * @param mappingProject
     * @Return: java.lang.Integer
     **/
    @PostMapping("/addMappingProject")
    Integer add(@RequestBody MappingProject mappingProject);

    /**
     * @Description:
     *             项目管理 删除方法  单个删除
     * @Author: York
     * @Date: 2020/6/4 0004 8:57
     * @param id
     * @Return: java.lang.Integer
     **/
    @GetMapping("/delMappingProject/{id}")
    Integer delMappingProject(@PathVariable("id") Long id);

    /**
     * @Description:
     *             项目管理 删除方法 批量删除
     * @Author: York
     * @Date: 2020/6/4 0004 8:58
     * @param ids
     * @Return: java.lang.Integer
     **/
    @PostMapping("/deleteBatchMappingProject")
    Integer delBatch(@RequestBody List<Object> ids);

    /**
     * @Description:
     *             项目管理 查询一条
     * @Author: York
     * @Date: 2020/6/4 0004 8:58
     * @param id
     * @Return: com.york.model.MappingProject
     **/
    @GetMapping("lectOne")
    MappingProject selectOne(@RequestParam("id") Long id);

    /**
     * @Description:
     *             项目管理 更新方法 单个更新
     * @Author: York
     * @Date: 2020/6/4 0004 8:58
     * @param mappingProject
     * @Return: java.lang.Integer
     **/
    @PostMapping("/updateMappingProject")
    Integer update(@RequestBody MappingProject mappingProject);

    /**
     * @Description:
     *             项目管理 查询方法 分页查询
     * @Author: York
     * @Date: 2020/6/4 0004 8:58
     * @param pageNo
     * @param pageSize
     * @Return: PageInfo
     **/
    @PostMapping("/mappingProjectByPage")
    PageInfo queryListByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);





    /**
     * @Description:
     *             根据userid查询仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:52
     * @param userId
     * @Return: java.util.List<com.york.model.Equipment>
     **/
    @GetMapping("/queryListEquipmentByUserId")
    List<Equipment> queryListEquipmentByUserId(@RequestParam("userId") Long userId);

    /**
     * @Description:
     *             新增仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:52
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addEquipment")
    Boolean addEquipment(@RequestBody Equipment equipment);

    /**
     * @Description:
     *             删除仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:53
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteEquipment")
    Boolean deleteEquipment(@RequestBody Equipment equipment);

    /**
     * @Description:
     *             修改仪器设备信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:53
     * @param equipment
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateEquipment")
    Boolean updateEquipment(@RequestBody Equipment equipment);
}
