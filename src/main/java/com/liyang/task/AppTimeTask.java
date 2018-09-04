package com.liyang.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务类 知识点 -- cron表达式
 */


@Component
public class AppTimeTask {

    @Scheduled(cron = "30 45 16 * * ?")
    public void test() {
        System.out.println("current time is : " + new Date());
    }
}
