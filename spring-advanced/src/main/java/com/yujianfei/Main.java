package com.yujianfei;

import com.yujianfei.aware.AwareService;
import com.yujianfei.conditional.ListService;
import com.yujianfei.config.AdvanceConfig;
import com.yujianfei.taskexecutor.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2019/12/6.
 * 启动类
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AdvanceConfig.class);

        // Aware测试
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        // 异步并发任务测试
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i =0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        // 测试conditional
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")
                + "系统下的列表命令为: "
                + listService.showListCmd());
    }
}
