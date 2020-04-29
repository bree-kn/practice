package com.example.practice.mybatis;

import com.example.practice.mapper.MybatisMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.sql.SQLException;

@Slf4j
@Service
//@Transactional(rollbackFor = Exception.class)
public class MybatisService {

    @Autowired
    private MybatisMapper mybatisMapper;

    public User getUser(int id) {
       User user = mybatisMapper.getUser(id);
        System.out.println(user);
        return user;
    }

//    @Transactional
      public void insert(String name){
        try {
            mybatisMapper.update(12);
            mybatisMapper.insert(name);
        }catch (Exception e){
            System.out.println("i am exception le");
            throw e;
        }
        log.info("update 语句");
    }

//    @Transactional(noRollbackFor = SQLException.class)
    @Transactional
    public void roll() throws InterruptedException {
        mybatisMapper.insert("bree");
        Thread.sleep(2000);
        mybatisMapper.update(2);
//        mybatisMapper.update(1/0);
    }
}
