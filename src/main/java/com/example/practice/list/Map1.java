package com.example.practice.list;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap是按照哈希桶数组中非空的槽依次遍历的，再加上哈希冲突的情况，与插入顺序相比，就更加乱了。
 * 而linkedHashMap是维护了一个贯穿所有元素的双向链表，遍历时，迭代器直接对双向链表迭代，从而保证了与插入顺序一致。
 * 1.hashmap,linkedHashmap:
 * 底层都是数组+链表+红黑树
 * 迭代器都是快速失败的，都是非线程安全
 * linkedhashmap有按插入和访问两种迭代顺序，而hashmap乱序，迭代顺序不可预测。
 */
public class Map1 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(8,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        System.out.println(map.toString());
    }
}
