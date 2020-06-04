package com.aaa.kay.controller;


import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.SpecialPost;
import com.aaa.kay.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/4 0004 8:55
 * @Version:1.0
 * @Description: 特殊岗位人员信息管理
 */
@RestController
public class SpecialPostController extends BaseController {

    @Autowired
    private MappingService iqySpecialPostService;

    /**
     * @Description:
     *             根据userId查询特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:55
     * @param userId
     * @Return: ResultData
     **/
    @GetMapping("/queryListSpecialPostByUserId")
    public List<SpecialPost> selectSpecialPostInfo(@RequestParam("userId") Long userId) {
        List<SpecialPost> specialPosts = iqySpecialPostService.queryListSpecialPostByUserId(userId);
        if (specialPosts.size()>0) {
            return specialPosts;
        }
        return null;
    }

    /**
     * @author lwq 
     * @description
     *    新增特殊岗位人员信息
     * @param: [specialPost]
     * @date 2020/6/2
     * @return com.aaa.six.base.ResultData
     * @throws 
     **/
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(SpecialPost specialPost){
        Boolean aBoolean = iqySpecialPostService.addSpecialPost(specialPost);
        if (aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
    }
    /**
     * @author lwq 
     * @description
     *    删除特殊岗位人员信息
     * @param: [specialPost]
     * @date 2020/6/2
     * @return com.aaa.six.base.ResultData
     * @throws 
     **/
    @PostMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(SpecialPost specialPost){
        Boolean aBoolean = iqySpecialPostService.deleteSpecialPost(specialPost);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * @author lwq
     * @description
     *    修改特殊岗位人员信息
     * @param: [specialPost]
     * @date 2020/6/2
     * @return com.aaa.six.base.ResultData
     * @throws
     **/
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(SpecialPost specialPost){
        Boolean aBoolean = iqySpecialPostService.updateSpecialPost(specialPost);
        if (aBoolean){
            return super.updateSuccess();

        }else {
            return super.updateFailed();
        }
    }
}
