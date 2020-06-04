package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.mapper.MappingProjectMapper;
import com.aaa.kay.model.MappingProject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aaa.kay.status.Status.*;

/**
 * @ClassName MappingProjectService
 * @Description: 项目管理
 * @Author 59983
 * @Date 2020/5/25
 * @Version V1.0
 **/
@Service
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    /**
     * @MethodName: pageSelectMappingProject
     * @Description: 项目管理主页查询项目信息
     * @Param: [pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo<com.aaa.kay.model.MappingProject>
     * @Author: 59983
     * @Date: 2020/5/27
    **/
    public PageInfo<com.aaa.kay.model.MappingProject> pageSelectMappingProject(Integer pageNo,Integer pageSize)  {
        try {
            PageInfo<MappingProject> mappingProjectPageInfo = super.queryListByPage(pageNo, pageSize);
            if (mappingProjectPageInfo.getPageSize()>0){
                return mappingProjectPageInfo;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @MethodName: insertSelective
     * @Description: 添加新的项目并返回主键id
     * @Param: [mappingProject]
     * @Return: int
     * @Author: 59983
     * @Date: 2020/5/27
    **/
    public ResultData insertSelective(MappingProject mappingProject){
        // 添加新数据并返回主键id
        Integer insertSelective = mappingProjectMapper.insertSelective(mappingProject);
        System.out.println(insertSelective);
        ResultData resultData = new ResultData();
        if (null!=insertSelective){
            resultData.setCode("200").setData(insertSelective).setMsg("添加成功");
        }
        return resultData.setCode("300").setMsg("添加失败");
    }

}
