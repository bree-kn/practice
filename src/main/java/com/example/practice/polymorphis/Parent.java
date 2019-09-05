package com.example.practice.polymorphis;

/**
 * 多态：需要符合3个条件
 * 1.继承关系
 * 2.父类引用指向子类对象
 * 3.子类重写父类方法
 * 还有一种静态多态，一般认为Java中的函数重载是一种静态多态，因为他需要在编译期决定具体调用哪个方法、
 * 我认为，多态应该是一种运行期特性，Java中的重写是多态的体现。不过也有人提出重载是一种静态多态的想法，
 * 这个问题在StackOverflow等网站上有很多人讨论，但是并没有什么定论。我更加倾向于重载不是多态。
 */
public class Parent {
    public void call(){
        System.out.println("i am father");
    }
}
class Son extends Parent{
    @Override
    public void call() {
        System.out.println("i am son");
    }
}
class Daughter extends Parent{
    @Override
    public void call() {
        System.out.println("i am daughtter");
    }
}
class Test1{
    public static void main(String[] args) {
        Parent p = new Son();
        p.call();
        Parent p1 = new Daughter();
        p1.call();
    }
}