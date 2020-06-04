package com.aaa.kay.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(String code, String msg, String detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }
    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
