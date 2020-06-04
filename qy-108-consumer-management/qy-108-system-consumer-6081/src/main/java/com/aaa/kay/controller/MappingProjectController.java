package com.aaa.kay.controller;

import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.MappingProject;
import com.aaa.kay.service.MappingService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/6/4 0004 10:22
 * @Version:1.0
 * @Description:
 */
@RestController
@Api(value = "项目信息", tags = "项目管理板块")
public class MappingProjectController extends BaseController {
    @Autowired
    private MappingService iqyMappingProjectService;


    /**
     * @Description:
     *             项目管理 新增方法 单个新增
     * @Author: York
     * @Date: 2020/6/4 0004 10:23
     * @param mappingProject
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addMappingProject")
    @ApiOperation(value = "项目管理", notes = "新增一条数据")
    public ResultData add(@RequestBody MappingProject mappingProject){
        Integer i = iqyMappingProjectService.add(mappingProject);
        if (i!= null && i!=0) {
            return insertSuccess();
        }
        return insertFailed();
    }

    /**
     * @Description:
     *             项目管理 删除方法  单个删除
     * @Author: York
     * @Date: 2020/6/4 0004 10:23
     * @param id
     * @Return: com.york.base.ResultData
     **/
    @GetMapping("/delMappingProject/{id}")
    @ApiOperation(value = "项目管理", notes = "删除一条数据")
    public ResultData delMappingProject(@PathVariable("id")Long id){
        Integer integer = iqyMappingProjectService.delMappingProject(id);
        if (integer!= null && integer!=0) {
            return deleteSuccess();
        }
        return deleteFailed();
    }

    /**
     * @Description:
     *             项目管理 删除方法 批量删除
     * @Author: York
     * @Date: 2020/6/4 0004 10:23
     * @param ids
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/deleteBatchMappingProject")
    @ApiOperation(value = "项目管理", notes = "批量删除数据")
    public ResultData delBatch(@RequestBody List<Object> ids) throws  Exception{
        Integer integer = iqyMappingProjectService.delBatch(ids);
        if (integer>0) {
            return deleteSuccess();
        }
        return deleteFailed();
    }

    /**
     * @Description:
     *            项目管理 查询方法 单个查询
     * @Author: York
     * @Date: 2020/6/4 0004 10:23
     * @param id
     * @Return: com.york.base.ResultData
     **/
    @GetMapping("/selectOne")
    @ApiOperation(value = "项目管理", notes = "查询一条数据")
    public ResultData selectOne(@RequestParam("id")Long id){
        MappingProject mappingProject = iqyMappingProjectService.selectOne(id);
        if (null != mappingProject&& !"".equals(mappingProject)) {
            return selectSuccess(mappingProject);
        }
        return selectFailed();
    }

    /**
     * @Description:
     *             项目管理 更新方法 单个更新
     * @Author: York
     * @Date: 2020/6/4 0004 10:24
     * @param mappingProject
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/updateMappingProject")
    @ApiOperation(value = "项目管理", notes = "更新一条数据")
    ResultData update(@RequestBody MappingProject mappingProject){
        Integer integer = iqyMappingProjectService.update(mappingProject);
        if (integer!=null && integer!=0){
            return updateSuccess();
        }
        return updateFailed();
    }

    /**
     * @Description:
     *             项目管理 查询方法 分页查询
     * @Author: York
     * @Date: 2020/6/4 0004 10:24
     * @param pageNo
     * @param pageSize
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/mappingProjectByPage")
    @ApiOperation(value = "项目管理", notes = "项目管理分页查询")
    public ResultData queryListByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo mappingProjectPageInfo = iqyMappingProjectService.queryListByPage(pageNo, pageSize);
        if (null!=mappingProjectPageInfo) {
            return selectSuccess(mappingProjectPageInfo);
        }
        return selectFailed();
    }
    @GetMapping("queryListMappingProjectByFiled")
    public ResultData<List<MappingProject>> queryListMappingProjectByFiled(@RequestBody Map map){
        try {
            ResultData<List<MappingProject>> listResultData = iqyMappingProjectService.queryListMappingProjectByFiled(map);
            if(null!=listResultData) {
                return listResultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("queryListMappingProjectByUserId")
    public List<MappingProject> queryListMappingProjectByUserId(
            @RequestParam("userId") Long userId) {
         return iqyMappingProjectService.queryListMappingProjectByUserId(userId);
    }
}
