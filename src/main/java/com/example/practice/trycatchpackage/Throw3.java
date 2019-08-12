package com.example.practice.trycatchpackage;

public class Throw3 {
    public static void main(String[] args) {
        try{
            System.out.println(div(10,0));
        }catch (Exception e){
            System.out.println("异常产生："+e);
            throw e;
        }
    }
    public static int div(int a, int b){
        System.out.println("start");
        int temp = 0;
        try{
            temp = a/b;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            System.out.println("end");
        }
        return temp;
    }

}
