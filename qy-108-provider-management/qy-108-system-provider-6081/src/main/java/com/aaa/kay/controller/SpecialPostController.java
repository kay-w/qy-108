package com.aaa.kay.controller;

import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.SpecialPost;
import com.aaa.kay.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:42
 * @Version:1.0
 * @Description: SpecialPostController特殊岗位人员的控制层
 */
@RestController
public class SpecialPostController extends BaseController {

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
    public ResultData<List<SpecialPost>> queryListSpecialPostByUserId(@RequestParam Long userId){
        try {
            SpecialPost principal = new SpecialPost();
            principal.setUserId(userId);
            List<SpecialPost> principals = specialPostService.queryList(principal);
            if(null!=principals&&principals.size()>0){
                return querySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryFailed();
    }
}
