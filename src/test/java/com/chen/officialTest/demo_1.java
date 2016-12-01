package com.chen.officialTest;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Package com.chen.officialTest
 * @Author chenh
 * @CreateDao 2016/12/1
 * @Description
 * @Version 1.0
 */
public class demo_1 {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();

        //声明一个Job并且绑定HellJob类
        JobDetail jobDetail = newJob(HellJob.class)
                .withIdentity("myJob","group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
    }
}
