package com.yujianfei.controller;

import com.yujianfei.entity.DemoObj;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {

    @RequestMapping("/advice")
    public String testAdvice(@ModelAttribute("msg") String msg, DemoObj obj) {
        System.out.println(obj.toString());
        throw new IllegalArgumentException("非常抱歉,参数有误," + "来自@ModelAttribute:" + msg);
    }

}
