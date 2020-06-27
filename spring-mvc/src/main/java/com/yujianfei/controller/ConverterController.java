package com.yujianfei.controller;

import com.yujianfei.entity.DemoObj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @RequestMapping(value = "/convert", produces = { "application/x-wisely" })
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }

}
