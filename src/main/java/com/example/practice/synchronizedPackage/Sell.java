package com.example.practice.synchronizedPackage;

public class Sell extends Thread{
    private static int tickets = 100;
    public void run(){
        while(true){
            if(tickets>0){
                System.out.println(Thread.currentThread().getName()+" sell :"+tickets--);
            }
        }
    }
}
class Test1{
    public static void main(String[] args) {
        new Sell().start();
        new Sell().start();
        new Sell().start();

    }
}
