package com.example.practice.constructor;

/**
 * 1.static修饰变量，方法可以直接用类来调用，
 * 因为static的属性或方法是放在jvm方法区里边的，属于类的信息，不需要New就可以直接使用，属于类，所有直接用类名就可以调用，而一般的属性
 * 是属于某个对象的，是放在堆里边的，需要new对象才可以。
 * 2.static修饰的方法为什么不能访问非静态的方法？
 * 因为static方法是静态方法，属于类的，在加载类的时候就已经加载了，
 * 比构造方法早，此时非静态方法属性还没有初始化，
 * 所以不能直接在静态方法里边调用非静态的，可以在静态方法里边先new对象，再通过对象来调用非静态的即可。main方法dog1.testStatic();
 *
 * 3.final修饰变量不能被修改
 * 4.封装就是让属性尽可能私有，方法尽可能公有
 * 其他类访问私有属性时，可以通过get,set
 * 1、类变量（static修饰的变量）：在程序加载时系统就为它在堆中开辟了内存，堆中的内存地址存放于栈以便于高速访问。静态变量的生命周期--一直持续到整个"系统"关闭
 * 2、实例变量：当你使用java关键字new的时候，系统在堆中开辟并不一定是连续的空间分配给变量（比如说类实例），然后根据零散的堆内存地址，通过哈希算法换算为一长串数字以表征这个变量在堆中的"物理位置"。 实例变量的生命周期--当实例变量的引用丢失后，将被GC（垃圾回收器）列入可回收“名单”中，但并不是马上就释放堆中内存
 * 3、局部变量：局部变量，由声明在某方法，或某代码段里（比如for循环），执行到它的时候在栈中开辟内存，当局部变量一但脱离作用域，内存立即释放
 */
public class Dog1 {
   private String name = "小白";
    String strain = "dog1";
    static final int health = 50;
    static int aa;
    final static int mm=0;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog1(){
        this.name = "bree";
    }
    public void testStatic(){
        System.out.println("teststatic");
    }
    public static void main(String[] args) {
        Dog1 dog1 = new Dog1();
        System.out.println(dog1.name);
        dog1.name = "stone";
        System.out.println(dog1.name);
        dog1.aa = 9;
        aa = 0;
        dog1.testStatic();
    }
}
class Test1{
    public static void main(String[] args) {
        System.out.println(Dog1.aa);
        Dog1 dog1 = new Dog1();
        dog1.setName("st");
        System.out.println(dog1.getName());
    }
}