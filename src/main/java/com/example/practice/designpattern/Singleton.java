package com.example.practice.designpattern;

/**
 * 懒汉，线程不安全
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    public String testSing(){
        System.out.println("this is testSing");
        return "this is test";
    }
}
class Test{
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().testSing());
    }
}
