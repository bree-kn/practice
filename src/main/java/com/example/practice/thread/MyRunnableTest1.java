package com.example.practice.thread;

import com.example.practice.controller.GetValue;
import com.example.practice.synchronizedPackage.RunnableTest2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable里边的run方法没有抛异常，Callable里边的call方法抛异常了，
 * 所以RunnableTest1里边的run方法也不能抛异常，只能try catch
 */
public class MyRunnableTest1 {
    public static GetValue getValue = null;
    public static void main(String[] args) {
        new Thread(new RunnableTest1()).start();
//        System.out.println("cost time is:"+new MyRunnableTest1().getTime());
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future future = pool.submit(new RunnableTest1());
        try {
            if(null == future.get()){
                System.out.println("任务完成了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("cost time is:"+getValue.toString());
    }
//    public void updateTime(long costtime){
//        this.time = costtime;
//    }
//
//    public long getTime() {
//        return time;
//    }
}
class RunnableTest1 implements Runnable{
    @Override
    public void run(){
        long beginTime = System.currentTimeMillis();
        int sum = 0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<=100;i++){
            sum += i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
//        new MyRunnableTest1().updateTime(endTime-beginTime);
//        MyRunnableTest1.getValue.updateTime(endTime-beginTime);
        System.out.println(endTime-beginTime);
    }
}
