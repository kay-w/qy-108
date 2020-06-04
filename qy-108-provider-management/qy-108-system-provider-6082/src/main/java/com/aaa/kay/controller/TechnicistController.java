package com.aaa.kay.controller;


import com.aaa.kay.model.Technicist;
import com.aaa.kay.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/6/4 0004 10:09
 * @Version:1.0
 * @Description:
 */
@RestController
public class TechnicistController {
    @Autowired
    private TechnicistService technicistService;

   /**
    * @Description:
    *             根据userId查询技术员信息
    * @Author: York
    * @Date: 2020/6/4 0004 10:10
    * @param userId
    * @Return: java.util.List<com.york.model.Technicist>
    **/
    @PostMapping("/selectTechnicistInfo")
    public List<Technicist> selectTechnicistInfo(@RequestParam("userId") Long userId){
        List<Technicist> technicists = technicistService.selectTechnicistInfo(userId);
        if (technicists.size()>0){
            return technicists;
        }
        return null;
    }

    /**
     * @Description:
     *             新增技术员
     * @Author: York
     * @Date: 2020/6/4 0004 10:10
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/addTechnicist")
    public Boolean addTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = technicistService.addTechnicist(technicist);
        if (aBoolean){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             修改技术员信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:10
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/deleteTechnicist")
    public Boolean deleteTechnicist(@RequestBody Technicist technicist){
        boolean b = technicistService.deleteTechnicist(technicist);
        if (b){
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *             修改单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 10:10
     * @param technicist
     * @Return: java.lang.Boolean
     **/
    @PostMapping("/updateTechnicist")
    public Boolean updateTechnicist(@RequestBody Technicist technicist){
        return technicistService.updateTechnicist(technicist);
    }
}
