package com.aaa.kay.mapper;

import com.aaa.kay.model.Dict;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DictMapper extends Mapper<Dict> {

    /**
     * 分页条件查询
     * @param dict
     * @return
     */
    List<Dict> selectDictByField(Dict dict);
}