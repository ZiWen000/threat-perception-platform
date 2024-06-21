package com.tpp.threat_perception_platform.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class BaseLineTask {

    @Scheduled(cron = "*/5 * * * * *")
    public void task01(){
        // 每隔5秒执行一次动作
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("每隔5秒执行一次动作：" + simpleDateFormat.format(System.currentTimeMillis()));
    }
}
