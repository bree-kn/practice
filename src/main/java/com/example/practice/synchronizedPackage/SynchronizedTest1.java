package com.example.practice.synchronizedPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        MyThread m = new MyThread();
        for(int i=0;i<5;i++){
            pool.execute(new MyThread());
        }
        pool.shutdown();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        synchronized (MyThread.class){
            System.out.println(Thread.currentThread().getName()+" start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }
}
