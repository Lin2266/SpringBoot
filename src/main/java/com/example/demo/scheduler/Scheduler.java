package com.example.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    //Java Cron Expression表達式用於配置 CronTrigger 的實例，它是 org.quartz.Trigger 的子類。
    //顯示如何從每天上午 9:00 開始到上午 9:59 結束，每分鐘執行一次任務
    @Scheduled(cron = "0 * 9 * * ?")
    public void cronJobSch(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

    //固定速率Fixed Rate 調度器用於在特定時間執行任務。它不會等待上一個任務的完成。這些值應以毫秒為單位。
    @Scheduled(fixedRate = 1000)
    public void fixedRateSch(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);
    }

    //固定延遲Fixed Delay 調度器用於在特定時間執行任務。它應該等待上一個任務完成。這些值應以毫秒為單位。
    //initialDelay 是在初始延遲值之後任務將第一次執行的時間。
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelaySch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Delay scheduler:: " + strDate);
    }
}
