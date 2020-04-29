package com.example.practice.common;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleTestDemo {

    @Async
//    @Scheduled(cron = "0/1  *  *  *  *  ?")
    public void testsc() throws InterruptedException {
        while (true){
            System.out.println("i am cron1:"+Thread.currentThread().getName());
//            Thread.sleep(10000);
        }
    }


//    @Scheduled(cron = "0/5  *  *  *  *  ?")
    public void test1sc(){
        System.out.println("i am cron2:"+Thread.currentThread().getName());
    }
}
