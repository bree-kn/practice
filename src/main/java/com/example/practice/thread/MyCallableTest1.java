package com.example.practice.thread;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
//并发执行10个线程异步的，不用for循环-----------
/**future.get:
 *用for循环来一次调用多个线程的话，如果里边有future.get,那么后边的代码就必须等到当前的线程获得返回值才可以执行，
 * for循环中是一次只执行一个线程，然后再future.get获取这个时间2001，执行了3次，所以花费的时间就是6003
 * 而不放在for循环中则同时执行，即并发执行，即异步的执行，则只花费2001，future.get直接就获取了值。
 * 所以效率慢则是因为放在for循环里边的缘故。一个线程若执行任务需要花费很长时间，则总体的时间将成倍增加。所以不建议放在for循环。
 */
public class MyCallableTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread[] threads = new Thread[10];
//        for(int i=0;i<threads.length;i++){
//            threads[i] = new Thread(new MyCallable());
//        }

        ExecutorService pool = Executors.newFixedThreadPool(10);
        long begin = System.currentTimeMillis();
        List<Future> list =new ArrayList<>();
        for(int i=0;i<10;i++){
            Future future1 = pool.submit(new MyCallable());
            list.add(future1);
        }
        pool.shutdown();
        if(!CollectionUtils.isEmpty(list)){
            for(Future future : list){
                System.out.println(future.get());
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("costtime:"+(end-begin));

/*
        long begin = System.currentTimeMillis();
        Future future2 = pool.submit(new MyCallable());
        Future future3 = pool.submit(new MyCallable());
        Future future4 = pool.submit(new MyCallable());
        pool.shutdown();
        System.out.println("2:"+future2.get());
        System.out.println("-----");

        System.out.println("3:"+future3.get());
        System.out.println("---");
        System.out.println("4:"+future4.get());
        System.out.println("---------");
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
        Thread.sleep(10000);
        long endtime = System.currentTimeMillis();
        return endtime-begintime;
    }
}
