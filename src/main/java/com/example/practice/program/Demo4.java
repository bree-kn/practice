package com.example.practice.program;

import java.util.Arrays;
import java.util.List;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Demo4 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
    }
}
