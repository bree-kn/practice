package com.example.practice.trycatchpackage;

import java.util.Scanner;

/**
 * 自定义异常类
 * 需要继承Exception或者RuntimeException,只需要提供无参构造和一个带参的构造
 *1.e.printStackTrace();执行此句之后出了catch之后的语句还可以执行
 */
public class MyException extends Exception{
    public MyException(){}
    public MyException(String message){
        super(message);
    }
    public MyException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
    }
}
class StudentDemo{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("please input");
        int num = scan.nextInt();
        try {
            check(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
        System.out.println("abc");
    }
    public static void check(int num) throws MyException {
        if(num < 0 || num > 100){
            throw new MyException("please input 0-100");//com.example.practice.trycatchpackage.MyException: please input 0-100
//            throw new MyException(ErrorEnum.REQUEST_FAIL);//输出com.example.practice.trycatchpackage.MyException: 请求失败
        }else{
            System.out.println("the num can use");
        }
    }
}