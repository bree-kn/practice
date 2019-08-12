package com.example.practice.synchronizedPackage;

public class Dog {
    private int count = 0;

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        test();
    }

    public void test() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " calling");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}