package com.example.practice.constructor;

public class Demo1 {
    int age;//默认赋值为0
    String name;//默认赋值为null

    /**
     * 构造方法可以private,protected,public,也可以默认不写，如果是private则别的类不能调用。单例模式
     */
      Demo1() {
//        System.out.println("i am demo1");
//        this.age = 1;
    }
    void Demo1Test1(){
        System.out.println("我是在测试一个类里边a方法调用b方法");
    }
    Demo1(int age){
          this.Demo1Test1();//如果在方法内部调用同一个类的另一个方法，就不必使用this。
    }
}
class Demo1Test{
    public static void main(String[] args) {
//        Demo1 demo1 = new Demo1();
//        System.out.println(demo1.age);
//        System.out.println(demo1.name);
        Demo1 demo1 = new Demo1(10);

    }
}