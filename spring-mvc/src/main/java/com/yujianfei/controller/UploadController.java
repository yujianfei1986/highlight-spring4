package com.yujianfei.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
        try {

            FileUtils.writeByteArrayToFile(new File("E:/export/" + file.getOriginalFilename()),
                    file.getBytes());
            return "OK";

        } catch (Exception e) {
            e.printStackTrace();
            return "wrong";
        }
    }

}
