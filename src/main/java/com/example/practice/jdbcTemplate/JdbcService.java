package com.example.practice.jdbcTemplate;

import com.example.practice.trycatchpackage.ResultData;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface JdbcService {
    ResultData add(User user);
    ResultData update(int id,String password) throws FileNotFoundException;
    ResultData delete(int id);
    ResultData selectValue(int id);
    ResultData select(int id);
    ResultData selectAll();
    ResultData selectMap(int id);
    ResultData batchInsert();
}
