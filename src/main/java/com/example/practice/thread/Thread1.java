package com.example.practice.thread;

/**
 * 线程默认的优先级是继承父线程的优先级，如果把父线程的优先级设置为4，所以导致子线程的优先级也变成4.
 * 1最低优先级，5正常优先级，10最高优先级,
 * 如果设置超过1-10这个范围的数字，则报Exception in thread "main" java.lang.IllegalArgumentException
 */
public class Thread1 {
    public static void main(String[] args) {
/*
        Thread thread = new Thread();
        System.out.println(thread.getPriority());//5
*/
/*
        Thread.currentThread().setPriority(3);//当前线程
        Thread thread = new Thread();//新创建的线程
        System.out.println(thread.getPriority());//3
*/
/*
        Thread.currentThread().setPriority(11);//Exception in thread "main" java.lang.IllegalArgumentException
        Thread thread = new Thread();
        System.out.println(thread.getPriority());
*/
    }
}
