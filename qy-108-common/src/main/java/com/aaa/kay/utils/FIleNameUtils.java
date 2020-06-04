package com.aaa.kay.utils;

import org.apache.commons.io.FilenameUtils;

import java.util.Random;

/**
 * @ClassName FIleNameUtils
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/31
 * @Version V1.0
 **/
public class FIleNameUtils {
    private FIleNameUtils(){

    }
    /**
     * @MethodName: getFIleName
     * @Description: 文件名的生成方法
     * @Param: []
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/31
    **/
    public static String getFIleName(){
        // 获取系统时间当前的毫秒数
        long timeMillis = System.currentTimeMillis();
        // 创建Random对象
        Random random = new Random();
        // 创建随机数 0到999
        Integer randomNum = random.nextInt(999);
        System.out.println(randomNum);
        // 生成最终的文件名 当前的毫秒数加随机数 不够的加0  %占位符d数字 03 三位
        String fileName = timeMillis + String.format("%03d", randomNum);
        System.out.println(fileName);
        return fileName;

    }

    public static void main(String[] args) {
        System.out.println(FIleNameUtils.getFIleName());
    }
}
