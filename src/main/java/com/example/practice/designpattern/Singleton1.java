package com.example.practice.designpattern;

/**
 * 懒汉，线程安全,效率低
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){}
    public static synchronized Singleton1  getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
    public String testSing(){
        System.out.println("this is testSing");
        return "this is test";
    }
}
class Test1{
    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance().testSing());
    }
}
