package com.example.practice.synchronizedPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest2 implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        RunnableTest2 r = new RunnableTest2();
       for(int i=0;i<5;i++){
           pool.execute(r);
       }
       pool.shutdown();

    }
}
