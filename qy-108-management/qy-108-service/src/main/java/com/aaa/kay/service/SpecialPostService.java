package com.aaa.kay.service;


import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.SpecialPostMapper;
import com.aaa.kay.model.SpecialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.aaa.kay.staticstatus.TimeProperties.*;

/**
 * @Author: York
 * @Date: 2020/6/1 0001  8:41
 * @Version:1.0
 * @Description: SpecialPostService特殊岗位人员的实现层
 */
@Service
public class SpecialPostService extends BaseService<SpecialPost> {

    @Autowired
    private SpecialPostMapper specialPostMapper;

    /**
     * @Description:
     *             新增特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:50
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    public Boolean addSpecialPost(SpecialPost specialPost){
        if (null == specialPost && "".equals(specialPost)){
            return false;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            specialPost.setCreateTime(format);
            int insert = specialPostMapper.insert(specialPost);
            if (insert > 0){
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * @Description:
     *             删除特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:49
     * @param specialPost
     * @Return: boolean
     **/
    public boolean deleteSpecialPost(SpecialPost specialPost) {
        if ("".equals(specialPost) && null == specialPost) {
            return false;
        } else {
            int i = specialPostMapper.deleteByPrimaryKey(specialPost);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * @Description:
     *             修改特殊岗位人员信息
     * @Author: York
     * @Date: 2020/6/4 0004 8:49
     * @param specialPost
     * @Return: java.lang.Boolean
     **/
    public Boolean updateSpecialPost(SpecialPost specialPost) {
        //判断user是否为空
        if ("".equals(specialPost) && null == specialPost) {
            return false;
        } else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_TYPE);
            String format = simpleDateFormat.format(date);
            specialPost.setCreateTime(format);
            int i = specialPostMapper.updateByPrimaryKey(specialPost);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
