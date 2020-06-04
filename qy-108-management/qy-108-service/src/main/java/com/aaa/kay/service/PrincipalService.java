package com.aaa.kay.service;


import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.PrincipalMapper;
import com.aaa.kay.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.aaa.kay.staticstatus.TimeProperties.*;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:34
 * @Version:1.0
 * @Description: Principal法人信息实现层
 */
@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;

    /**
     * @Description:
     *             新增单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:42
     * @param principal
     * @Return: java.lang.Boolean
     **/
    public Boolean addPrincipal(Principal principal){
        if (null == principal && "".equals(principal)){
            return false;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            principal.setCreateTime(format);
            int insert = principalMapper.insert(principal);
            if (insert > 0){
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * @Description:
     *             删除单位负责人信息
     * @Author: York
     * @Date: 2020/6/4 0004 9:42
     * @param principal
     * @Return: boolean
     **/
    public boolean deletePrincipal(Principal principal) {
        if ("".equals(principal) && null == principal) {
            return false;
        } else {
            int i = principalMapper.deleteByPrimaryKey(principal);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * @Description:
     *             修改单位负责人
     * @Author: York
     * @Date: 2020/6/4 0004 9:44
     * @param principal
     * @Return: java.lang.Boolean
     **/
    public Boolean updatePrincipal(Principal principal) {
        //判断user是否为空
        if ("".equals(principal) && null == principal) {
            return false;
        } else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            principal.setCreateTime(format);
            int i = principalMapper.updateByPrimaryKey(principal);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
