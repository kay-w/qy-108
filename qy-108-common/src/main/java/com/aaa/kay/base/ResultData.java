package com.aaa.kay.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName ResultData
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/12
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
}
