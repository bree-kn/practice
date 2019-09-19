package com.example.practice.synchronizedPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.静态synchronized方法和synchronized(class)一样，当不同线程监视同一个实例或者不同的实例时，都会等待
 * RunnableTest run1 = new RunnableTest();
 * pool.execute(run1);
 * pool.execute(run1);
 * 2.非静态synchronized方法和synchroinzed(this)一样，不同线程监视同一个实例时，等待，监视不同实例时，不等待
 */
public class RunnableTest implements Runnable {
    private static boolean flag = true;

//  静态方法和synchronized(class)一样，都等待
/*
        private static synchronized void test1() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
        }
*/
    public void test1() throws InterruptedException {
        synchronized (RunnableTest.class) {
            System.out.println(Thread.currentThread().getName()+" start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }
/*同synchronized (this)一样的结果
    public synchronized void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " end");
    }
*/

    /**     synchronized (this)
     * pool.execute(new RunnableTest());
     * pool.execute(new RunnableTest());
     * 不同的实例，2个线程不等待，直接运行
     * pool.execute(run1);
     * pool.execute(run1);
     *相同的实例，2个线程则等待，一个执行完了，另外一个再执行
     * @throws InterruptedException
     */
/*
    public void test1() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
        }
    }
*/


    @Override
    public void run() {
        try {
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        RunnableTest run1 = new RunnableTest();
        pool.execute(new RunnableTest());
        pool.execute(run1);
        pool.shutdown();
    }
}
