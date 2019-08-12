package com.example.practice.trycatchpackage;

import java.util.Scanner;

/**
 * finally里边如果没有return,则还try->catch->finally->try或catch里边的return
 * finally里边如果有return,则直接退出了，不在执行任何代码
 */
public class TryCatch {
    public static void main(String[] args) {
        TryCatch tryCatch = new TryCatch();
        tryCatch.input();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        try {
//            System.out.println("请输入");
//            int num = scan.nextInt();
            throw new Exception("try");
//            System.out.println(num);
//            return;
        } catch (Exception e) {
//            System.out.println("输入的数字不匹配");
            e.printStackTrace();
            throw e;
//            throw new Exception("catch");

//            input();
//            System.out.println("this is catch");
//            return;
        }finally {
            System.out.println("finlly");
            return;
        }
    }
}
