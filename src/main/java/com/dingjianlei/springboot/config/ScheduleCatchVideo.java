package com.dingjianlei.springboot.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCatchVideo {
	@Scheduled(cron="0 0/1 * * * ?") 
    public void executeFileDownLoadTask() {
        Thread current = Thread.currentThread();  
        System.out.println("定时任务1:"+current.getId());
        System.out.println(("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName()));
    }

}
