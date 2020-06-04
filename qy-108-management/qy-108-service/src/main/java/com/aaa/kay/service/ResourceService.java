package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;

import com.aaa.kay.mapper.ResourceMapper;
import com.aaa.kay.model.Resource;
import com.aaa.kay.utils.DateUtils;
import com.aaa.kay.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




/**
 * @Author zk
 * @Date 2020/5/29
 */
@Service
public class ResourceService extends BaseService<Resource> {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
    * @author zk
    * @Date
    *   根据 项目id查询 附件材料
    */
    public List<Resource> selectResourceByRefBizId(Object id){
        if (null != id) {
            List<Resource> list =  resourceMapper.selectResourceByRefBizId(id);
            if (list!=null && !list.isEmpty()){
                return list;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    /**
    * @Author: He create on 2020/6/3 20:11
    * @param: [resource]
    * @return: java.lang.Integer
    * @Description: 添加新的附件信息
    */
    public Integer insertResource(Resource resource){
        if (null != resource){
            resource.setCreateTime(DateUtils.getCurrentDate());
            resource.setId(Long.valueOf(IDUtils.getUUID()));
            int insert = resourceMapper.insert(resource);
            if (insert > 0){
                return insert;
            }
            return null;
        }
        return null;
    }

}
