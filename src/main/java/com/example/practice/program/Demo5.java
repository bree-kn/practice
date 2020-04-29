package com.example.practice.program;

/**
 * char的默认值是一个空格
 */
public class Demo5 {
    private static Dog dog;
    private static byte a;
    private static String m;
    private short b;
    private int c;
    private long d;
    private float e;
    private double f;
    private boolean g;
    private char h;
    public static void main(String[] args) {
        System.out.println(dog);
        System.out.println(a);
        System.out.println(m);
        Demo5 demo5 = new Demo5();
        System.out.println(demo5.a);
        System.out.println(demo5.b);
        System.out.println(demo5.c);
        System.out.println(demo5.d);
        System.out.println(demo5.e);System.out.println(demo5.f);
        System.out.println(demo5.g);System.out.println("--"+demo5.h+"--");

    }

}
