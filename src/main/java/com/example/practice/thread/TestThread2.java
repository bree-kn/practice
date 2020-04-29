package com.example.practice.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

public class TestThread2 {

    @Autowired
    private TestThread2Service testThread2Service;

    public static void main(String[] args) {
        System.out.println("name:"+Thread.currentThread().getName());
        long begin = System.currentTimeMillis();
        System.out.println("begin");
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    try {
//                        Thread.sleep(100);
//                        System.out.println("num is:"+i+" thread is:"+Thread.currentThread().getName());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

        //多线程执行标准
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 执行业务逻辑方法serviceTest()
        MyRunnable1 myRunnable1 = new MyRunnable1();
        for(int i=0;i<10;i++){
            executorService.submit(myRunnable1);
        }
        executorService.shutdown();
        System.out.println("end");
        long end = System.currentTimeMillis();
        System.out.println("costtime:"+(end-begin));
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum += i;
        }
        System.out.println("name is:"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
