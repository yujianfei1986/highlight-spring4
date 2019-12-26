package com.yujianfei.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2019/12/6.
 * spring 定时任务
 */
@Service
public class ScheduledTaskService {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 12 16 ? * *"  )
    public void fixTimeExecution(){
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }
}
