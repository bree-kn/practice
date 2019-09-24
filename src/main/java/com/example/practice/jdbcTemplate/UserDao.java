package com.example.practice.jdbcTemplate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
    int add(User user);
    List<User> findById(int id);
    int updateUser(int id,String password);
    int updateEmp(int id,double salary) throws FileNotFoundException;
    int delete(int id);
    int selectValue(int id);
    User select(int id);
    List<User> selectAll();
    Map selectMap(int id);
    List<Integer> batchInsert() throws Exception;
}
