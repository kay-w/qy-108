package com.aaa.kay.utils;

import java.util.UUID;

/**
 * @ClassName IDUtils
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
public class IDUtils {
    private IDUtils(){

    }
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


}
