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
 */
public class Dog1 {
   private String name = "小白";
    String strain = "dog1";
    static final int health = 50;
    static int aa;

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