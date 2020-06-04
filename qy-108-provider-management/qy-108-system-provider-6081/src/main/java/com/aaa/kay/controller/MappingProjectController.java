package com.aaa.kay.controller;

import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.MappingProject;
import com.aaa.kay.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: York
 * @Date: 2020/5/31 0031  10:12
 * @Version:1.0
 * @Description: MappingProjectController
 */
@RestController
@RequestMapping("mappingProject")
public class MappingProjectController extends BaseController {

    @Autowired
    private MappingProjectService mappingProjectService;
    /**
     * @Description:
     *             条件查找所有的测绘项目信息，当条件为空时查询所有的信息,这个针对的是主页的搜索查询业务
     * @Author: York
     * @Date: 2020/5/31 0031 10:34
     * @param
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingProject>>
     **/
    @GetMapping("queryListMappingProjectByFiled")
    public ResultData<List<MappingProject>> queryListMappingProjectByFiled(@RequestParam Map map){
        try {
            MappingProject mappingProject = mappingProjectService.newInstance(map);
            List<MappingProject> mappingProjects = mappingProjectService.queryList(mappingProject);
            if(null!=mappingProjects&&mappingProjects.size()>0) {
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
    /**
     * @Description:
     *             根据单位用户编号查询数据信息，这个是mappingUnit与mappingProject关联查询要用到userID
     * @Author: York
     * @Date: 2020/5/31 0031 18:31
     * @param userId
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.MappingProject>>
     **/
    @PostMapping("queryListMappingProjectByUserId")
    public ResultData<List<MappingProject>> queryListMappingProjectByUserId(@RequestParam Long userId){
        try {
            MappingProject mappingProject = new MappingProject();
            mappingProject.setUserId(userId);
            List<MappingProject> mappingProjects = mappingProjectService.queryList(mappingProject);
            if(null!=mappingProjects&&mappingProjects.size()>0) {
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
    /**
     * @Description:
     *             通过主键id查询项目信息，这个暂时没用到但是主键查询肯定会用，留着到备用
     * @Author: York
     * @Date: 2020/5/31 0031 19:11
     * @param id
     * @Return: com.york.base.ResultData<com.york.model.MappingProject>
     **/
    @GetMapping("queryMappingProjectById")
    public ResultData<MappingProject> queryMappingProjectById(@RequestParam Long id){
        try {
            MappingProject mappingProject = new MappingProject();
            mappingProject.setId(id);
            MappingProject mappingProjects = mappingProjectService.queryOne(mappingProject);
            if(null!=mappingProjects&&"".equals(mappingProjects)) {
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }

}
