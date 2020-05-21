package com.aaa.kay.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName GetIP
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/18
 * @Version V1.0
 **/
public class GetIPAndTime {
         /**
          * @MethodName: getIpAddress
          * @Description: TODO
          * @Param: [request]
          * @Return: java.lang.String
          * @Author: 59983
          * @Date: 2020/5/18
         **/
        public static String getIpAddress(HttpServletRequest request) {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        }
        public static String getTime(){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();//创建一个date对象保存当前时间
            String dateStr = df.format(date);//format()方法将Date转换成指定格式的String
            return dateStr;

        }




}
