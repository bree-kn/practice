package com.example.practice.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.为什么需要包装类，使其基本类型具有包装类的性质
 * 1比如list里边可以添加int,double等类型的数据，为什么不能写List<int>呢?
 * 因为在java 1.5之后有自动装箱拆箱，放入容器时会自动把基本类型的数字装箱为相应的引用类型，即自动装箱把int->Integer
 * 有的地方会自动拆箱装箱，比如：将基本类型的值放在集合里边，包装类型和基本类型的大小比较，包装类型的运算
 * 2.parseInt,parseLong...返回基本类型
 *   String.ValueOf(""),Long.valueOf(),Integer.ValueOf()...返回封装类型
 *   parseInt   String->int
 *   ValueOf    String,int->Integer
 *   intValue   Integer->int
 * 3.基本数据类型不用new来创建，不会在堆上创建，直接在栈内存中存储，所以更高效。如果是成员变量的话是要存储在堆里边。
 */
public class List1 {
    public static void main(String[] args) {
//        Byte,Short,Long  -128-127
        Integer a=1;
        System.out.println(a==1?"等于":"不等于");
        Boolean bool=false;
        System.out.println(bool?"真":"假");
/*
        boolean flag = true;
        Integer i = null;
        int j = 1;
        int k = flag ? i : j;//此处反编译后发现为int k = flag ? i.intValue() : j   因为比较运算时都会拆箱的，空指针异常
        System.out.println(k);
*/
/*
        Integer i = 1;//等价于Integer i = Integer.ValueOf(1);即int->Integer
        int j = i.intValue();//Integer->int
        int b = Integer.parseInt("123");//string->int
        Integer c = Integer.valueOf("123");//string,int->Integer
*/
/*
        String s1 = String.valueOf(1);
        String s2 = String.valueOf("s");
        String s3 = String.valueOf(3.3);
        String s4 = String.valueOf('a');
*/
/*
        long abcLong = Long.parseLong("456");//返回基本数据类型，
        Long cdeLong = Long.valueOf(abcLong);//返回封装类型
        System.out.println(abcLong == cdeLong.longValue());
*/

//        List<int> list = new ArrayList<>()
/*
        List list = new ArrayList<>();
        list.add(1.1);
        System.out.println(list.toString());
*/
    }
}
