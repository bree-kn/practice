package com.example.practice.thread;

import java.util.concurrent.*;

/**
 * future.get()会暂时阻塞代码执行，直到获得值才可以,即后边的代码都暂停执行，影响效率。
 */
public class MyThreadTest1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future future = pool.submit(new CallableTest1());
        pool.shutdown();
        try {
            System.out.println("need value");
            System.out.println("value is:"+future.get());
            System.out.println("-------------");
            System.out.println("............");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("abcldflkdal;k");
        System.out.println("all done");
    }
}
class CallableTest1 implements Callable{

    @Override
    public Integer call() throws InterruptedException {
        int sum = 0;
        Thread.sleep(2000);
        for(int i=0;i<=100;i++){
            sum += i;
        }
        return sum;
    }
}