package com.example.practice.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @RequestMapping("testMybat/{id}")
    public User GetUser(@PathVariable int id){
        return mybatisService.getUser(id);
    }

//    @Transactional
    @RequestMapping("insert")
    public void insert(@RequestParam("name")String name){
        mybatisService.insert(name);
    }

    @RequestMapping("testrollback")
    public void roll() throws InterruptedException {
        mybatisService.roll();
    }
}
