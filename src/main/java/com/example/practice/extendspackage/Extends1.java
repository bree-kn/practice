package com.example.practice.extendspackage;

/**
 * 父类私有属性不能被继承，因为对于子类是不可见的，私有属性只在当前类能看到。
 */
public class Extends1 {
    private String name="bree";
    int age;
}
class Son1 extends Extends1{
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        System.out.println(son1.age);
//        System.out.println(son1.name);
    }
}
