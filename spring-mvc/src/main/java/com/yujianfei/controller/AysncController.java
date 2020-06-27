package com.yujianfei.controller;

import com.yujianfei.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AysncController {

    @Autowired
    private PushService pushService;

    @RequestMapping("/defer")
    public DeferredResult<String> deferredCall() { //2
        return pushService.getAsyncUpdate();
    }

}
