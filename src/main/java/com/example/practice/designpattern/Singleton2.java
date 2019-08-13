package com.example.practice.designpattern;

/**
 * 饿汉，在类加载时实例化
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
    public String testSing(){
        System.out.println("this is testSing");
        return "this is test";
    }
}
class Test2{
    public static void main(String[] args) {
        System.out.println(Singleton2.getInstance().testSing());
    }
}
