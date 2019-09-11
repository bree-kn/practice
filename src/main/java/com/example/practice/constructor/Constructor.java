package com.example.practice.constructor;

/**
 * 1.构造方法用来初始化类的一个新对象，并且为实例变量赋予合适的初始值，所以构造方法不需要返回类型
 * Constructor c = new Constructor();
 * 但是隐式返回类的对象，即默认返回对象本身。
 * 2.每个类都会有一个toString方法，当需要用时，可以重写它，则会返回一个字符串如：c.toString()
 * 如果没有重写这个toString方法时，那么c.toString会返回一个com.example.practice.basicknowledge.Constructor@72ea2f77
 * 所以需要重写
 * 3.构造方法不能被继承，不能重写，因为构造方法的作用是创建对象并对变量初始化，如果重写了之后，
 * 创建父类的对象就会有影响。
 * 4.子类构造方法中第一行是super(),因为子类继承了父类的成员变量，在使用前必须给其初始化，所以就调用super
 * 5.构造方法不能私有的，否则其他类不能调用，protected,public默认,都可以调用,其实也可以private,不过就不能被别人通过new对象调用了
 * 6.构造方法可以是默认修饰符，即什么都不写Constructor(String name, int age) {}
 */
public  class Constructor {
    private String name;
    private int age;
    public static String grop;

    Constructor(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //    abstract void dd();//public abstract class Constructor抽象方法的类必须是抽象类，用abstract修饰

    //成员方法中（静态非静态）都不能定义static的变量，因为方法中定义的只能是局部变量，只能在这个方法中访问，
    //而static的变量是全局变量
    public  static final void A(){
//        static int a;

//        System.out.println("grop=="+name);
        System.out.println(grop);
        System.out.println(B());
//        System.out.println(c());//静态方法只能访问静态变量，静态方法
    }
    public int c(){
        return 9;
    }

    public static int B(){
        return 9;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {
        Constructor c = new Constructor();//抽象类不能实例化
        c.setAge(20);
        c.setName("aa");
//        System.out.println(c.getAge());
//        System.out.println(c.toString());
        c.A();
    }
    public Constructor(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class C{
    private static int a;
    private int b;

    public static int getA() {
        return a;
    }

    public static void main(String[] args) {
        Constructor c1 = new Constructor("mm",3);
        System.out.println(c1.getAge());
        System.out.println(getA());
    }
}