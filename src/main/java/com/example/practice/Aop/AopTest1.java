package com.example.practice.Aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTest1 {

    @RequestMapping("testAop")
    public String test(){
        System.out.println(1/1);
        return "test";
    }
}
