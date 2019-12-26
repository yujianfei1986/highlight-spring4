package com.yujianfei;

import com.yujianfei.config.CommonConfig;
import com.yujianfei.event.DemoPublisher;
import com.yujianfei.prepost.BeanWayService;
import com.yujianfei.prepost.JSR250WayService;
import com.yujianfei.profile.DemoBean;
import com.yujianfei.scope.DemoPrototypeService;
import com.yujianfei.scope.DemoSingletonService;
import com.yujianfei.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2019/11/5.
 * 启动类
 */
public class Main {

    public static void main(String[] args) {
        //验证scope(singleton,prototype)
        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(CommonConfig.class);
        DemoSingletonService s1 = context1.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context1.getBean(DemoSingletonService.class);
        DemoPrototypeService p1 = context1.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context1.getBean(DemoPrototypeService.class);
        System.out.println("s1与s2是否相等：" + s1.equals(s2));
        System.out.println("p1与p2是否相等：" + p1.equals(p2));

        //验证el(配置文件属性值注入等)
        CommonConfig resourceService = context1.getBean(CommonConfig.class);
        resourceService.outputResource();
        DemoService demoService = context1.getBean(DemoService.class);
        demoService.printResult();

        //验证bean的生命周期
        BeanWayService beanWayService = context1.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context1.getBean(JSR250WayService.class);
        context1.close();

        //验证profile
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(CommonConfig.class);
        context.refresh();
        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());

        //验证事件监听
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("hello application event");
    }

}
