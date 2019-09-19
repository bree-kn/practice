package com.example.practice.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jdbcService")
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
         userDao.add(user);
    }
}
