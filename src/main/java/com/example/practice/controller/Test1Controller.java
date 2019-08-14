package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1Controller {
//静态变量赋值用set方法
//非静态变量赋值直接用此变量即可，放在变量上或者set方法上都可以
//    @Value("${name}")
    private  String name;
    private static int outTime;
    @RequestMapping("/test1")
    public void execute(){
        System.out.println(name);
        System.out.println(outTime);
    }

    @Value("${name}")
    public  void setName(String aa){
        name = aa;
    }

    @Value("${socket.out_time}")
    public  void setOutTime(int curOutTime){
        outTime = curOutTime;
    }
}
