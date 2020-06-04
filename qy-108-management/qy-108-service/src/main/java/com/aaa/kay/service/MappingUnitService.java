package com.aaa.kay.service;

import com.aaa.kay.base.BaseService;
import com.aaa.kay.mapper.MappingUnitMapper;
import com.aaa.kay.model.MappingUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: York
 * @Date: 2020/5/31 0031  10:06
 * @Version:1.0
 * @Description: MappingUnitService测绘单位的实现层
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;
    public List<MappingUnit> queryListMappingUnitByFiled(MappingUnit mappingUnit){
        return mappingUnitMapper.select(mappingUnit);
    }
}
