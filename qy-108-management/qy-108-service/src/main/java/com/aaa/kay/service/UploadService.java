package com.aaa.kay.service;

import com.aaa.kay.properties.FTPProperties;
import com.aaa.kay.utils.DateUtils;
import com.aaa.kay.utils.FIleNameUtils;
import com.aaa.kay.utils.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName UploadService
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/31
 * @Version V1.0
 **/
@Service
public class UploadService {
    @Autowired
    private FTPProperties ftpProperties;
    public Boolean upload(MultipartFile file){
        // 获取原始文件的名称 获取目的就是为了获取文件的后缀名
        String oldFileName = file.getOriginalFilename();
        // 获取新的文件名 不带后缀
        String newFileName = FIleNameUtils.getFIleName();
        // 获取到最终的文件名 新的带后缀的文件名
        String substring = oldFileName.substring(oldFileName.lastIndexOf("."));
        System.out.println("测试文件名"+substring);
        newFileName=newFileName+oldFileName.substring(oldFileName.lastIndexOf("."));
        System.out.println("最终的文件名"+newFileName);
        try {
            String filePath = DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            System.out.println("需要添加的路径"+filePath);
            return FTPUtils.uploadFile(ftpProperties.getHost(),ftpProperties.getPort(),ftpProperties.getUsername(),ftpProperties.getPassword(),filePath,ftpProperties.getBasePath(),newFileName,file.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;

    }
}
