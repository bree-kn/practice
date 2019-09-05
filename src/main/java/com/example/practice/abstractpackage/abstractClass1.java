package com.example.practice.abstractpackage;

/**
 * 1.一个类只能继承类，不能继承接口，（类->类==继承关系）
 * 2.一个类可以实现接口(必须实现接口里边的所有方法)，类不能继承接口，即（类->接口==实现关系）
 * 3.一个接口不能实现接口（因为接口里边是抽象方法，自己本身是不能包含实现方法的），可以继承多个接口(接口->接口==继承关系)，
 * 4.抽象类
 * 一个普通类继承了一个抽象类，必须重写这个抽象类的所有抽象方法，（普通类里边不会允许包含抽象方法）
 * 一个抽象类继承了。。。。。，不用。。。。。。。。。。。。。。；（抽象类里边允许包含抽象方法）
 * 抽象类和抽象方法必须用abstract声明
 * 5.抽象类和普通父类区别（都是把共有的代码放在父类里边）：
 * 抽象类一定是父类，父类不一定是抽象类
 */
//实例化的概念：在堆中创建一块空间，A a = new A(),来存放A对象的属性即成员变量，用a指向这个地址。
//抽象类不能被实例化，但是又存在构造器是因为构造器是在子类实例化的时候调用，
//    抽象类只在分配了在栈中的引用，没有分配堆中的内存。程序都有一个代码段,再内存中需要占据一定的内存,而抽象类没有具体的实现方法,无法具体的给它分配内存空间,所以为了安全,不JAVA不允许抽象类,接口直接实例化
// 接口不能被实例化，因为包含常量抽象方法，常量是存在静态区的，所以实例化接口的话，没有可以存储的值，只是浪费空间而已，所以没必要实例化它。
//
public abstract class abstractClass1 {
    private static final int age=1;
    public abstractClass1() {
    }

    public abstract void say();
    public abstract String say1();
    String say2(){
        return "this is abstract say2";
    }
}
 abstract class abs2{

}
 class B extends abstractClass1{

//    String say2(){
//        return "i am B.say2";
//    }

     @Override
     public void say() {

     }

     @Override
     public String say1() {
         return null;
     }

//     public static void main(String[] args) {
//         abstractClass1 abstractfather = new B();
//         abstractfather a = new abstractClass1();
//         System.out.println(abstractfather.say2());
//     }
 }


 //接口
  interface A{
    static final int a=1;
    int b = 2;//可以不用写static final
//     private int c=3;//接口中不允许私有成员,因为外界无法访问，本来一般情况是外界要访问私有的话，可以通过new本类的对象来访问，但是接口不能new 对象，所以就不能用private
     void say3();
    public void say4();//也可以不用写abstract
}
class Test2 implements A{

    public static void main(String[] args) {
        A a = new Test2();
        System.out.println(A.b+""+Test2.b);
    }
    @Override
    public void say3() {

    }

    @Override
    public void say4() {

    }
}
interface d{}
interface C extends A,d{
public void say5();
}

class Test3 implements C{


    @Override
    public void say3() {

    }

    @Override
    public void say4() {

    }

    @Override
    public void say5() {

    }
}


class M {
    void f(){
        System.out.println("M");
    }
}
class M1 extends M{
    void f(){
        System.out.println("m1");
    }
}
class M2 extends M{
    void f(){
        System.out.println("m2");
    }
}
class Test4{
    public static void main(String[] args) {
        M m = new M1();
        m.f();
         m = new M2();
        m.f();
    }
}