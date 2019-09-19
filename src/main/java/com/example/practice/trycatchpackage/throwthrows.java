package com.example.practice.trycatchpackage;

import javax.validation.constraints.Null;

/**
 * 1.try catch:
 * 如果一段代码出问题了，
 * (1)	如果没有try catch,那么自己自动会向上级抛出异常的，直到遇到处理的语句，如果没有遇到处理的代码，则会抛到虚拟机由虚拟机处理，将错误信息打印出来。
 * (2)	如果有try catch,在catch里边如果只是简单的打印东西，程序会继续往下走，因为已经catch处理了，但其实是最终返回的是错误的结果，
 * (3)	如果此时catch打印了一些信息后没有处理能力的话，会用throw 这个异常出去，那么就是继续往上层抛，直到遇到处理的代码为止。
 * (4)	总结：一般的代码起始不用写try catch,反正程序会自动抛出异常的，但是如果想要打印一些特定的信息的话，则用try catch,在catch里边去输出各种信息，比如也可以return
 * Resultdata 即退出程序，总之各种逻辑均可。
 * e. printStackTrace()和log.error(“”,e)效果一样,都会打印出堆栈信息。
 * Log.error(“error message”,e);如果存在e，则会打印错误信息的堆栈信息，如果没有只会打印“error message”
 *
 * throw抛出异常时，如果没有try catch,则由throws来抛给这个方法的调用者，让这个方法的调用者去处理，它也是用catch,或throws来处理
 * 如果有try catch来处理的话，就用catch来捕获
 * try{
 *      throw new Exception();
 * }catch(){}
 * try 异常信息，catch捕获异常，throw抛出异常，throws抛出可能存在的异常，throw抛出的异常要么catch处理，要么throws给调用者来处理。
 * throw new Exception时调用这个方法的方法声明上要加throws Exception.
 * throw e时不需要加throws Exception.
 * throw new Exception是指抛出另外的异常，而throw e是指try中遇到的异常。
 * 如果catch和finally里边都存在throw new Exception则会执行finally中throw的异常来终止程序，和return存在try,catch,finally一样,都是在finally中进行终止的。
 * 如果程序中有异常，并且throw new Exception则方法体中抛的是throw new Exception的异常
 */
public class throwthrows {
    public static void main(String[] args) throws Exception {
        throwthrows t = new throwthrows();
        try {
            t.function();
        }catch (Exception e){
            System.out.println("this is catch");
            throw new Exception("bbb");//throw new Exception是指抛出另外的异常，而throw e是指try中遇到的异常。
//            throw e;//如果执行了此句那么后边的throw ,finally都不会执行了。
        }
        finally {
            throw new Exception("this is finally");
        }
    }
    //这个方法体里边其实不用写try catch,因为反正都会向上抛异常的。
    public void function(){
        System.out.println(1/0);
    }
}
