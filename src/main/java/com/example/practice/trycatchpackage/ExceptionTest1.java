package com.example.practice.trycatchpackage;

/**
 * catch了这个error,所以不报错
 */
public class ExceptionTest1 {
    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 0;
//        try {
//            System.out.println(a / b);
//            //catch的参数可以多个异常
//        }catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e){
//            System.out.println("can skip this error");
//            System.out.println(e.getMessage());//异常的消息字符串
//            System.out.println(e.toString());//异常信息简单描述
//            e.printStackTrace();//获取异常类名和异常信息，以及异常出现的位置
//        }
//        System.out.println("done");
       int m = getMe();

    }
    public static int getMe(){
        int a = 0;
        try{
            System.out.println(30/0);
            a = 20;
        }catch (Exception e){
            return 30;
        }finally {
            return 40;
        }
    }
}
