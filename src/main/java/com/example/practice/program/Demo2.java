package com.example.practice.program;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("please input str");
        String str = scan.nextLine();
        System.out.println("please input char");
        String s = scan.nextLine();
        String[] str1 = str.split("");
        int count = 0;
        for(String ss : str1){
            if(ss.equals(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}
