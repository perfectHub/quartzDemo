package com.chen.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Package com.chen.task
 * @Author chenh
 * @CreateDao 2016/12/1
 * @Description
 * @Version 1.0
 */
@Service
public class TaskJob {

//    @Scheduled(cron = "0/5 * * * * ?")   //注解配置表达式
    public void taskJob(){
        System.out.println("taskJob is running...");
    }
}
