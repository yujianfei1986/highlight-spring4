package com.yujianfei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

}
