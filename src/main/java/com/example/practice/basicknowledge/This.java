package com.example.practice.basicknowledge;
/**
 * 1.this()只能在构造方法的第一行，不能在普通方法中
 * 2.new一个对象
 * A a = new A();此时a被占用着，即new A返回一个地址，这个地址赋值给引用a了，java认为这个对象是有用的，不会回收对象，
 * 如果之后执行了
 * a = null 或 a = new A();则这个a不在持有之前对象的地址了，变成了空或者新的地址，即a指向空或指向新的地址，则之前的对象就
 * 无法访问方法了，那么gc垃圾回收器就会认为这个对象没用了，将他从内存中释放掉。
 * 即没用人引用这个对象的话，就会被回收掉。
 */
public class This {
    private String name;
    private int age;

    public This(String name){
        this.name = name;
    }

    public This(String name, int age) {
        this.name = name;
        this.age = age;
//        this("i am");//如果把this放在这个位置，那么这个this传过来的值会覆盖上边的值的内容，即name会覆盖上边name,所以只能放第一行不覆盖其他的
    }

    public int A(){
        System.out.println(this.name);
        return this.age;
    }

    public void B(){
        System.out.println(this.A());
    }
    public static void main(String[] args) {
        //String a 只是声明了一个变量，存储在栈中，String b = new String();不仅在栈中声明了这个变量，同时还在堆中划分了一片区域，变量存储在这片区域。
        //String a = "abc";表示堆中填充了内容，不一定创建对象了，先在栈中查找有没有这个对象，如果有，则用已存在的abc，没有则创建一个对象
        String a;//a是一个引用，没有指向一个对象。
        String b = new String();
        String c = "i am c";
//        System.out.println(a);
        System.out.println(b == null);//false,因为b指向了一个对象，所以不等于null
        System.out.println(c == null);


/*
        This t = new This("a",3);
        System.out.println(t.name);
//        System.out.println(this.name);
*/
    }
}
