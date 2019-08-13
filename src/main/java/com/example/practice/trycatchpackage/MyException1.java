package com.example.practice.trycatchpackage;

import java.util.Scanner;

/**
 * 1.自定义异常继承自RuntimeException
 * catch (Exception e){
 *             System.out.println(e);
 *  }必须写在最后边，否则报错
 *  2.继承自RuntimeException时可以不用处理，即抛出异常之后就停止运行了
 *  后边的语句不执行了，继承自Exception的必须捕获或者抛出，必须处理
 */
public class MyException1 extends RuntimeException {
}
class ExceptionTest{
    public static void main(String[] args) {
        //此时不用try catch的话，就抛出异常的堆栈信息了。
//        try {
            check(111);
//        }catch (MyException1 e){
//            e.printStackTrace();
//        }
        System.out.println("done");
    }
    public static void check(int num)  {
        if(num != 10){
//            throw new MyException1();
            throw new MyException1();
        }else{
            System.out.println("can use");
        }
    }
}