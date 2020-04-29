package com.example.practice.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Demo1Thread {
//    @Resource
//    private Demo1A demo1A;

    @RequestMapping("main")
    public  void main() throws InterruptedException {
        System.out.println("main name:"+Thread.currentThread().getName());
        System.out.println("begin");
/*1
        MyRunnableDemo1 demo1 = new MyRunnableDemo1();
        Thread thread = new Thread(demo1,"runnable 在跑");//1
        thread.start();//必须用start,不能用run
*/
/*2
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(demo1);
        }
        executorService.shutdown();
*/
//        demo1A.say();
//        System.out.println("end");

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin:"+Thread.currentThread().getName());
//        new Demo1A().say();//用这种方法好像不能执行异步，不能体现多线程
        System.out.println("end");
    }
}
class MyRunnableDemo1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=2;i++){
            try {
                System.out.println("thread name:"+Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@Component
class ScheduleTest{
//    @Scheduled(cron = "0/30 * * * * *")
    public void scheduleTest(){
        System.out.println("i am schedule");
    }
}

