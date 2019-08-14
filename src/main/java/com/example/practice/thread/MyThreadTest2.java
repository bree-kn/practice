package com.example.practice.thread;

/**
 * 主线程中调用了子线程，但是往往子线程需要进行大量的耗时运算
 * ，主线程经常在子线程之前结束，但是如果主线程在处理完其他的事情后，
 * 需要子线程的处理结果，则用join,也就是主线程等待子线程完成后再结束
 * 就是子线程调用了join，然后join后边的代码必须等子线程执行完后才执行。
 */
public class MyThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        MyThread t = new MyThread();
        t.setName("a");
        t.start();
        t.join();
        System.out.println(t.costtime);
        System.out.println(t.value1);
    }
}

class MyThread extends Thread{
    public long costtime;
    public String value1;
    @Override
    public void run() {
        value1 = "value1";
        long begintime = System.currentTimeMillis();
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println(sum);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endtime = System.currentTimeMillis();
        costtime = endtime - begintime;
    }
}

/*
class MyThread extends Thread {
    private String value1;

    private String value2;


    public void run()
    {
        value1 = "value1";
        value2 = "value2";
    }

    public static void main(String[] args) throws InterruptedException {
//想要获取子线程执行的结果，则可以用t.join,也可以用当线程的值为null时，让线程thread.sleep(100),直到不为null为止。

        MyThread t1 = new MyThread();
        t1.start();
        t1.join();
*/
/*
        while (t1.value1 == null || t1.value2 == null){
            Thread.sleep(100);
        }
*//*

        System.out.println(t1.value1);
        System.out.println(t1.value2);
    }


}

*/
