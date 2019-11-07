package com.example.practice.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.ArrayList.subList不可强转为ArrayList
 * 2.CopyOnWriteArrayList边可以遍历边add,remove，防止发生ConcurrentModificationException，虽然防止了抛这个异常，但是在for循环遍历的时候还是不能访问到
 * 新增加的元素。
 * CopyOnWriteArrayList容器即写时复制的容器，即当我们往一个容器里添加元素的时候，不直接往当前容器添加，而是先将当前容器进行copy,复制出一个新的容器，
 * 然后新的容器里添加元素，添加完后，再将原容器的引用指向新的容器。
 * 注意：CopyOnWriteArrayList中的add/remove等写方法是需要加锁的，目的是为了避免copy出n个副本来，导致并发写，但是CopyOnWriteArrayList
 * 的读方法是没有加锁的。
 */
public class List3 {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>(){{
           add("aa");
           add("bb");
           add("cc");
        }};
        for(String s : list){
            list.add("dd");
            System.out.println(s);
        }
//        System.out.println(list);
/*
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(9);
        for(Integer i : list){
            list.add(10);
            System.out.println(i);
        }
*/
/*
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<5;i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        List<Integer> list1 = (ArrayList) list.subList(1,3);
//        ArrayList list1 = (ArrayList) list.subList(1,3);//Exception in thread "main" java.lang.ClassCastException
        System.out.println(list1);
   */
    }

}
