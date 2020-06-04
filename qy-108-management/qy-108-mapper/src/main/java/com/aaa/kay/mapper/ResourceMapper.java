package com.aaa.kay.mapper;

import com.aaa.kay.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ResourceMapper extends Mapper<Resource> {

    /**
     * @Author xyg
     * @Date 22:37 2020\6\4 0004
     * 根据项目id查询该项目的附件材料信息
     * @Param [id]
     * @return java.util.List<com.aaa.kay.model.Resource>
     **/
    List<Resource> selectResourceByRefBizId(Object id);

    /**
     * @Author xyg
     * @Date 22:37 2020\6\4 0004
     * 根据类型和单位id查询附件信息
     * @Param [map]
     * @return com.aaa.kay.model.Resource
     **/
    Resource selectResourceByIdAndType(Map map);
}