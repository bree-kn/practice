package com.example.practice.thread;

import java.util.concurrent.*;

/**future.get:
 *用for循环来一次调用多个线程的话，如果里边有future.get,那么后边的代码就必须等到当前的线程获得返回值才可以执行，
 * 但是分开每次提交一个线程，那么各个线程之间不会阻塞，分别执行各自的代码，去获取返回值。
 * 因为每次提交一个线程时，是由主线程去执行的，即main方法执行的，所以不分顺序，全部去执行，但是for循环里边不可以，
 * 从0-4分别取执行，0去获取返回值的时候，后边的代码先不执行，阻塞
 *.. 花费的时间成倍增加
 */
public class MyCallableTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        long begin = System.currentTimeMillis();
        for(int i=0;i<3;i++){
            Future future1 = pool.submit(new MyCallable());
            Object time = future1.get();
            System.out.println(i+":"+time);
            System.out.println(i+"abc");
            System.out.println(i+"mmdsak");
        }
        pool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("costtime:"+(end-begin));

/*
        long begin = System.currentTimeMillis();
        Future future2 = pool.submit(new MyCallable());
        Future future3 = pool.submit(new MyCallable());
        Future future4 = pool.submit(new MyCallable());
        pool.shutdown();
        System.out.println("2:"+future2.get());
        System.out.println("3:"+future3.get());
        System.out.println("4:"+future4.get());
        long end = System.currentTimeMillis();
        System.out.println("costtime:"+(end-begin));
*/

    }
}
class MyCallable implements Callable{
    @Override
    public Long call() throws InterruptedException {
        long begintime = System.currentTimeMillis();
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum += i;
        }
        Thread.sleep(2000);
        long endtime = System.currentTimeMillis();
        return endtime-begintime;
    }
}
