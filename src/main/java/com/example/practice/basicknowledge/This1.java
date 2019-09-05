package com.example.practice.basicknowledge;

/**
 * 构造方法里边this位于第一行，this()调用构造方法必须在构造方法里边写，不能再其他方法里边
 * A：访问成员变量
 * this.成员变量      --》调用本类成员变量
 * super.成员变量     --》调用父类成员变量
 * B:访问构造方法
 * this(..)           -->调用本类构造方法
 * super(..)          -->调用父类构造方法
 * C:访问成员方法
 * this.成员方法       --》调用本类的成员方法
 * super.成员方法      --》调用父类的成员方法
 */
public class This1 {
    private String name;
    private int age;
    private String group;
    public This1() {
        this("aa",9);//调用构造方法
        this.A();//调用其他方法,可以在构造方法里边写
    }

    public void A() {
//        this();//this()调用构造方法必须在构造方法里边写，不能再其他方法里边
        System.out.println("i m a");
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

    public This1(String name, int age) {
//        this();//此处不能调用this,不能每个构造方法都写this,否则就会递归调用，形成无限循环
        this.name = name;
        this.age = age;
    }

    public This1(String name, int age, String group) {
        this("aa",3);
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "This1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        This1 this1 = new This1();//This1{name='null', age=0}
        This1 this11 = new This1("bb",8);//This1{name='bb', age=8}
        System.out.println(this1);
        System.out.println(this11);
    }
}
class ThisSon extends This1{
    public ThisSon() {
    }

    public ThisSon(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        This1 t = new This1();
        System.out.println(t.getName()+"=="+t.getAge());
    }
}

class This2{

}

class This3 extends This2{

}