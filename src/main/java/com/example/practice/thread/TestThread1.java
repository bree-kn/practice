package com.example.practice.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test方法里边有3部分，begin，test，end他们执行的顺序是按照先后执行的即begin-》test-》end，即同步执行的，主线程按照顺序执行
 * 只有一个线程在执行
 */
@RestController
public class TestThread1 {

    @Autowired
    private TestThread1Service testThread1Service;

    @RequestMapping("testThread1")
    public void test() throws InterruptedException {
        System.out.println("name:"+Thread.currentThread().getName());
        System.out.println("begin");
        testThread1Service.test();
        System.out.println("end");
    }
}
