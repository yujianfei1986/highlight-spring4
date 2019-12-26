package com.yujianfei;

import com.yujianfei.aop.DemoAnnotationService;
import com.yujianfei.aop.DemoMethodService;
import com.yujianfei.config.DIConfig;
import com.yujianfei.config.JavaConfig;
import com.yujianfei.di.UserFunctionService;
import com.yujianfei.di.UserFunctionServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2019/10/28.
 * 启动类
 */
public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DIConfig.class);
        UserFunctionService service = context.getBean(UserFunctionService.class);
        System.out.println(service.sayHello("word"));

        @SuppressWarnings("resource")
        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        UserFunctionServiceConfig userService = context1.getBean(UserFunctionServiceConfig.class);
        System.out.println(userService.sayHello("Java conifg"));

        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
    }

}
