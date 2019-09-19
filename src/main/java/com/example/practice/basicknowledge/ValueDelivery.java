package com.example.practice.basicknowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * 值传递
 */
public class ValueDelivery {
    public static void main(String[] args) {
//      集合传递
        List<Integer> list = new ArrayList<>();
        list.add(3);
        print2(list);
        System.out.println(list);

//        数组引用传递
        int[] arr = {1,2,3};
        print1(arr);
        System.out.println(arr[0]+""+arr[1]+""+arr[2]);
//String值传递
        String s = "aaa";
        display(s);
        System.out.println("display:"+s);
// int 值传递
        int a = 9;
        print(a);
        System.out.println("a:"+a);
    }
//集合传递
    public static void print2(List list){
        list.add(8);
        System.out.println(list);
    }
//数组引用传递
    public static void print1(int[] arr1){
        arr1[0] = 9;
        System.out.println(arr1[0]+""+arr1[1]+""+arr1[2]);
    }
//  String值传递
    public static void display(String a ){
        a = "9";
        System.out.println("a:"+a);
    }
//    int 值传递
    public static void print(int m){
        m = 19;
        System.out.println("m:"+m);
//        return m;
    }
}
