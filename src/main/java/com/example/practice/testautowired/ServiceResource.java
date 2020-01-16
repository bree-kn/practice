package com.example.practice.testautowired;

import org.springframework.stereotype.Service;

//@Service(value = "serviceA")
@Service
public class ServiceResource {

    public String testResource(){
        String a = "test resource";
        return a;
    }
}
