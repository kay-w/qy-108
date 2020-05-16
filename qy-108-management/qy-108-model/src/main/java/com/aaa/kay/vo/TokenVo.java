package com.aaa.kay.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName TokenVo
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class TokenVo implements Serializable {
    /*
    token的值
     */
    private String token;
    /*
    是否成功
     */
    private Boolean ifSuccess;
    /*
    token放入redis中的key值
     */
    private String redisKey;
}
