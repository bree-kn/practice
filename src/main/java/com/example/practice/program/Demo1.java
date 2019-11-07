package com.example.practice.program;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "ldsjf 89io9 fkdsaj 890 123456789";
        String[] arr = str.split(" ");
        System.out.println(arr[arr.length-1].length());
    }
}
