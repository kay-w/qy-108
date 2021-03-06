package com.aaa.kay.controller;

import com.aaa.kay.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadController
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/31
 * @Version V1.0
 **/
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean uploadFile(@RequestBody MultipartFile file){
        return uploadService.upload(file);
    }
}
