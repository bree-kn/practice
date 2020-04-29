package com.example.practice.thread;

import org.springframework.stereotype.Service;

@Service
public class TestThread1Service {
    public void test() throws InterruptedException {
        System.out.println("for name:"+Thread.currentThread().getName());
        for(int i=0;i<100;i++){
            Thread.sleep(100);
            System.out.println("num is:"+i);
        }
    }
}
