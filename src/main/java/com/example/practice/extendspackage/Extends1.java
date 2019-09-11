package com.example.practice.extendspackage;

/**
 * 父类私有属性不能被继承，因为对于子类是不可见的，私有属性只在当前类能看到。
 * 如果对象指向null,或指向新的地址，垃圾回收器gc则认为这个对象没用了，可以将它从内存中释放出来。回收的是new的那个对象。
 */
public class Extends1 {
    private String name="bree";
    int age;
}
class Son1 extends Extends1{
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1 = null;//指向了null
        son1 = new Son1();//指向了新的地址
        System.out.println(son1.age);
//        System.out.println(son1.name);
    }
}
