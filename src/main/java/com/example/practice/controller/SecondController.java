package com.example.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

@RestController
public class SecondController {

    public static GetValue getValue = null;

    @RequestMapping("execute")
    public void execute(String[] args) throws ExecutionException, InterruptedException {
/*        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future future = pool.submit(new MyCallable1());
        System.out.println(future.get());
        return (Long) future.get();
*/
/*
        GetValue getValue = new GetValue();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new MyRunnable2());
        Thread.sleep(8000);
        pool.shutdown();
        return getValue.toString();
*/
 /*       ExecutorService pool = Executors.newFixedThreadPool(2);
        System.out.println("提交任务前的时间："+getDate());
        Future future = pool.submit(new MyCallable1());
        System.out.println("提交任务后的时间："+getDate());
        System.out.println("获取结果是："+future.get()+getDate());
        pool.shutdown();
        updateTime();*/
/*
        ExecutorService pool = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable();
        Future future = pool.submit(myRunnable);
        System.out.println(future.get());
*/
/*
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i=0;i<8;i++){
//            Future<Object> future = (Future<Object>) pool.submit(new MyRunnable());
            pool.execute(new MyRunnable());
        }
        pool.shutdown();
*/
/*
        for(int i=0;i<2;i++){
            MyThread1 myThread1 = new MyThread1();
            myThread1.setName("aa");
            myThread1.start();
        }
*/
//      多个线程异步执行
/*
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("aa");
        myThread1.start();
        MyThread1 myThread2 = new MyThread1();
        myThread2.setName("bb");
        myThread2.start();
        MyThread1 myThread3 = new MyThread1();
        myThread3.setName("cc");
        myThread3.start();
*/
/*
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        Thread t1 = new Thread(myRunnable1,"mm");
        Thread t2 = new Thread(myRunnable2,"nn");
        t1.start();
        t2.start();
*/
/*
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"bb");
        Thread t2 = new Thread(myRunnable,"cc");
        t1.start();
        t2.start();
*/      //3个线程同时执行一个任务时即myRunnable3,如果不加锁synchronized,则程序结果会杂乱无章。
        MyRunnable3 myRunnable3 = new MyRunnable3();
        Thread thread1 = new Thread(myRunnable3, "aa");
        Thread thread2 = new Thread(myRunnable3, "bb");
        Thread thread3 = new Thread(myRunnable3, "cc");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }
}

class MyRunnable implements Runnable {
    private int count = 100;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + "----" + count);
        }
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println(costTime);
//        SecondController.getValue.updateTime(costTime);
    }
}

class MyRunnable3 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
//卖票
        while (tickets > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if(tickets>0){
                    System.out.println(Thread.currentThread().getName() + "--" + tickets--);
                }
            }
        }
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "----");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long costTime = System.currentTimeMillis() - startTime;
        SecondController.getValue.updateTime(costTime);
    }
}

class MyThread1 extends Thread {
    private int count1 = 100;

    @Override
    public void run() {
        while (count1-- > 0) {
            System.out.println(Thread.currentThread().getName() + "----" + count1);
        }
    }
}

class MyCallable1 implements Callable {
    @Override
    public Long call() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        long costTime = System.currentTimeMillis() - startTime;
        return costTime;
    }
}