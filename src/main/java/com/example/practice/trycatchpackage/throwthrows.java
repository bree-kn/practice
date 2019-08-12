package com.example.practice.trycatchpackage;

import javax.validation.constraints.Null;

/**
 * throw抛出异常时，如果没有try catch,则由throws来抛给这个方法的调用者，让这个方法的调用者去处理，它也是用catch,或throws来处理
 * 如果有try catch来处理的话，就用catch来捕获
 * try{
 *      throw new Exception();
 * }catch(){}
 * try 异常信息，catch捕获异常，throw抛出异常，throws抛出可能存在的异常，throw抛出的异常要么catch处理，要么throws给调用者来处理。
 */
public class throwthrows {
    public static void main(String[] args) throws Exception{
        throwthrows t = new throwthrows();
        try {
            t.function();
        }catch (Exception e){
            System.out.println("this is catch");
        }finally {
            throw new Exception("this is finally");
        }
    }
    public void function() throws Exception{
        System.out.println(1/0);
    }
}
