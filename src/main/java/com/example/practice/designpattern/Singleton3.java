package com.example.practice.designpattern;

/**
 * 双重校验锁
 */
public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
    public String testSing(){
        System.out.println("this is testSing");
        return "this is test";
    }
}
class Test3{
    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance().testSing());
    }
}
