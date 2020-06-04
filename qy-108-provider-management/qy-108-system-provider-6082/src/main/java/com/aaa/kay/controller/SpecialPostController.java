package com.aaa.kay.controller;


import com.aaa.kay.model.SpecialPost;
import com.aaa.kay.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:42
 * @Version:1.0
 * @Description: SpecialPostController特殊岗位人员的控制层
 */
@RestController
public class SpecialPostController {

    @Autowired
    private SpecialPostService specialPostService;


    /**
     * @Description:
     *             mappingUnit与SpecialPost通过userID绑定,使用userID查询单位的特殊岗位信息
     * @Author: York
     * @Date: 2020/6/1 0001 9:28
     * @param userId
     * @Return: com.york.base.ResultData<java.util.List<com.york.model.SpecialPost>>
     **/
    @GetMapping("queryListSpecialPostByUserId")
    public List<SpecialPost> queryListSpecialPostByUserId(@RequestParam("userId")  Long userId){
        try {
            SpecialPost principal = new SpecialPost();
            principal.setUserId(userId);
            List<SpecialPost> principals = specialPostService.queryList(principal);
            if(null!=principals&&principals.size()>0){
                return principals;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description:
     *             新增特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:47
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addSpecialPost")
    public Boolean addSpecialPost(@RequestBody SpecialPost specialPost){
        Boolean aBoolean = specialPostService.addSpecialPost(specialPost);
        if (aBoolean){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             删除特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:47
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteSpecialPost")
    public Boolean deleteSpecialPost(@RequestBody SpecialPost specialPost){
        boolean b = specialPostService.deleteSpecialPost(specialPost);
        if (b){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             修改特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:46
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateSpecialPost")
    public Boolean updateSpecialPost(@RequestBody SpecialPost specialPost){
        return specialPostService.updateSpecialPost(specialPost);
    }
}
