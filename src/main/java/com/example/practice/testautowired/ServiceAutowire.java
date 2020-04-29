package com.example.practice.testautowired;

import org.springframework.stereotype.Service;

@Service(value = "autowireaa")
public class ServiceAutowire {

    public String testautowire(){
        return "test autowire";
    }
}
