package com.example.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

//@RestController
public class TestController {

    @RequestMapping("execute")
    public static void execute(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            long start = System.currentTimeMillis();
            MyCallable myCallable = new MyCallable();
            FutureTask futureTask = new FutureTask(myCallable);
            new Thread(futureTask).start();
//            service.submit(myCallable);
            long costTime = System.currentTimeMillis()-start;
            System.out.println(Thread.currentThread().getName()+"执行完需要的时间："+costTime);
        }
/*
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
*/
/*        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
*/
    }
    public static void update(long costTime){
        System.out.println(Thread.currentThread().getName()+"花费的时间："+costTime);
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call(){
        return 44;
    }
}



class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"第"+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run(){
        long start = System.currentTimeMillis();
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+"第"+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long costTime = System.currentTimeMillis()-start;
        TestController.update(costTime);
        System.out.println(Thread.currentThread().getName()+"执行所用的的时间:"+costTime);
    }
}