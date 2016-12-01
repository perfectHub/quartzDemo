package com.chen.officialTest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Package com.chen.officialTest
 * @Author chenh
 * @CreateDao 2016/12/1
 * @Description
 * @Version 1.0
 */
public class HellJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Official is running...");
    }
}
