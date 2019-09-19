package com.example.practice.list;

import java.util.ArrayList;
import java.util.List;

public class List2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        for(int i=0;i<list.size();i++){
            String str = list.get(i).toString();
            System.out.println(str);
        }


/*
        List<Integer> list = new ArrayList<>();
        //增
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3,9);
        //改
        list.set(1,8);
        //删
        list.remove(0);
        System.out.println(list);
        //查
        System.out.println(list.get(1));

        System.out.println(list);
*/
    }
}
