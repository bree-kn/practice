package com.example.practice.trycatchpackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * logger.debug,logger.info,logger.warn,logger.error,logger.fatal的区别
 *
 * logger.debug,logger.info,logger.warn,logger.error,logger.fatal的作用都是把错误信息写到文本日志里
 * 不同的是它们表示的日志级别不同：
 * 日志级别由高到底是：fatal,error,warn,info,debug,低级别的会输出高级别的信息，高级别的不会输出低级别的
 * 信息，如等级设为Error的话，warn,info,debug的信息不会输出
 * 修改日志输出的级别要在log4j文件中进行配置
 * 项目正式发布后，一般会把日志级别设置为fatal或者error
 */

//log.error,全局异常处理
public class tryCatch1 {

    private static final Logger logger = LoggerFactory.getLogger(tryCatch1.class);

    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        }catch (Exception e){
            e.printStackTrace();
//            logger.error("this is error",e);//有这个逗号e的话会指出哪行报错的,会打印出堆栈信息。
            logger.error("aaa"+e);//如果是+号则只打印错误信息，不打印堆栈信息
        }
    }
}
