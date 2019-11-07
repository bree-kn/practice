package com.example.practice.program;

import java.util.*;

/**
 *用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据
 */
public class Demo3 {
    public static void main(String[] args) {
/*
        int length = 10;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            int num = 0;
            do{
                num = (int)(Math.random() * 1000+1);
            }while (list.contains(num));
            list.add(num);
        }
        Collections.sort(list);
        System.out.println(list);
*/
        List<Integer> inputList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println("please input");
            int num = scan.nextInt();
            inputList.add(num);
        }
        System.out.println(inputList);
        Set<Integer> set = new HashSet<>(inputList);
        List<Integer> list1 = new ArrayList<>(set);
        System.out.println(list1);
    }
}
