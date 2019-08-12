package com.example.practice.synchronizedPackage;

public class SynTest {
    public static void main(String[] args) {
        new SynThread1().start();
        new SynThread1().start();
    }

    public void syn(String userName) throws InterruptedException {
        synchronized (userName){
            System.out.println("enter:"+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("end:"+Thread.currentThread().getName());
        }
    }
}
class SynThread1 extends Thread{

    @Override
    public void run(){
        try{
            new SynTest().syn("abc");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
