package com.example.practice.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository(value = "UserDao")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJT(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }
    @Override
    public void add(User user) {
        String sql = "insert into User values(?,?,?)";
        jdbcTemplate.update(sql,user.getId(),user.getUsername(),user.getPassword());
    }
}
