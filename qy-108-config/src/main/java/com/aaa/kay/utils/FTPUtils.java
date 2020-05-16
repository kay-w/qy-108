package com.aaa.kay.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FTPUtils
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/17
 * @Version V1.0
 **/
public class FTPUtils {
    private FTPUtils(){}
    public static Boolean uploadFile(String host, Integer port, String username, String password,
                                     String filePath, String basePath, String fileName, InputStream input){
        //1 创建临时路径 方便后期使用
        String tmpPath="";
        //2 创建FTPClient对象 及时ftp提供给java的api
        FTPClient ftp = new FTPClient();
        try {
            //3 连接ftp服务器
            ftp.connect(host,port);// 不会抛异常 只会返回码
            //4 执行登录操作
            ftp.login(username,password);// 不会抛异常 只会返回码
            //5 验证服务器是否已经连接且登录成功 成功返回230 如果失败 返回530 503
            int reply = ftp.getReplyCode();
            // 6 根据返回的状态码进行判断
            if (!FTPReply.isPositiveCompletion(reply)){
                // 说明账号密码错误
                ftp.disconnect();//如果这里释放资源失败 那么finally会再次释放
                return false;
            }
            // 7需要判断目标上传路径是否存在 如果存在 true 如果不存在false
            if (!ftp.changeWorkingDirectory(basePath+filePath)){
                // 路径不存在 需要进行创建文件夹 filePath文件路径
                // 8 分割filepath
                String[] dirs = filePath.split("/");
                // 9 把basePath赋值给临时路径
                tmpPath=basePath;
                // 10 循环dir的数据进行拼接
                for (String dir:dirs){
                    // 严谨判断 判断dir一定不能为null
                    if (null==dir||"".equals(dir)){
                        continue;
                    }
                    // 11 拼接临时路径
                    tmpPath +="/"+dir;
                    // 再次判断检测确保该路径不存在
                    if (!ftp.changeWorkingDirectory(tmpPath)){
                        // 12 创建文件夹 makeDirectory创建文件夹的方法 返回Boolean
                        if (!ftp.makeDirectory(tmpPath)){
                            return false;
                        }else {
                            System.out.println(ftp.changeWorkingDirectory(tmpPath));
                        }
                    }
                }
            }
            // 14 如果if没有进入 说明文件夹存在 直接上传
            // ftp支持IO流太慢  改为二进制流上传
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 15 这才是真正文件上传 fileName文件名字 input文件
            if (!ftp.storeFile(fileName,input)){
                return false;
            }
            // 16 关闭输入流
            input.close();
            // 17 退出ftp
            ftp.logout();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (ftp.isConnected()){
                try {
                    ftp.disconnect();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return true;

    }
}
