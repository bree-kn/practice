/*
package com.example.practice.common;

import com.example.practice.thread.Demo1A;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * 容器启动初始化异步任务
 *//*

@Component
public class SpringFinishedListener implements InitializingBean {


    @Autowired
    private Demo1A demo1A;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet begin:"+Thread.currentThread().getName());
        demo1A.say();
        System.out.println("afterPropertiesSet end:"+Thread.currentThread().getName());
    }
}
*/
