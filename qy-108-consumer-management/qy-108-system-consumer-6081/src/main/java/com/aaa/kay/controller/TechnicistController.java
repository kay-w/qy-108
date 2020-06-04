package com.aaa.kay.controller;




import com.aaa.kay.base.BaseController;
import com.aaa.kay.base.ResultData;
import com.aaa.kay.model.Technicist;
import com.aaa.kay.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/4 0004 9:08
 * @Version:1.0
 * @Description: 技术员信息管理
 */
@RestController
public class TechnicistController extends BaseController {

    @Autowired
    private MappingService iqyTechService;

    /**
     * @Description:
     *             根据userId查询技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:09
     * @param userId
     * @Return: ResultData
     **/
    @PostMapping("/selectTechnicistInfo")
    public ResultData selectTechnicistInfo(@RequestParam("userId") Long userId) {
        List<Technicist> technicists = iqyTechService.selectTechnicistInfo(userId);
        if (technicists.size()>0) {
            return selectSuccess(technicists);
        }
        return selectFailed();
    }

    /**
     * @Description:
     *            新增技术员
     * @Author: York
     * @Date: 2020/6/4 0004 10:18
     * @param technicist
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(Technicist technicist){
        Boolean aBoolean = iqyTechService.addTechnicist(technicist);
        if (aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
    }

    /**
     * @Description:
     *             删除技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:18
     * @param technicist
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(Technicist technicist){
        Boolean aBoolean = iqyTechService.deleteTechnicist(technicist);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * @Description:
     *             修改技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:18
     * @param technicist
     * @Return: com.york.base.ResultData
     **/
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(Technicist technicist){
        Boolean aBoolean = iqyTechService.updateTechnicist(technicist);
        if (aBoolean){
            return super.updateSuccess();

        }else {
            return super.updateFailed();
        }
    }
}
