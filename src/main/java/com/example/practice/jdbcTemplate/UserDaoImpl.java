package com.example.practice.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * 栏位索引超过许可范围：1，栏位数：0。; nested exception is org.postgresql.util.PSQLException
 * 在sql中可能遇到这样的错误
 * 1.先去执行这个sql语句，如果执行没有数据，则是因为没有数据的原因。如果有数据，但是放在代码里边执行报错的话，可能是sql拼接的时候
 * 有" where pathlog.graph_question_id='?' "有这个引号，需要去掉这个引号改为"where id=? "即可
 */
@Repository(value = "UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        int idv = -1;
        //在给指定的值赋值时，必须写上这个字段的名称，否则报Caused by: java.sql.SQLException: Column count doesn't match value count at row 1
        //即插入的值和表里字段的名称对应不上。
        String sql = "insert into User(username,password) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                return ps;
            }
        };
        jdbcTemplate.update(psc,keyHolder);
        idv = Integer.parseInt(keyHolder.getKey().toString());
        return idv;
    }

    //查询返回一个集合用query(sql,new MyRowMapper(),id)
    @Override
    public List<User> findById(int id) {
        String sql = "select * from user where id=?";
        List<User> list = jdbcTemplate.query(sql,new MyRowMapper(),id);
        return list;
    }

    @Override
    public int updateUser(int id, String password) {
        String sql = "update user set password=? where id=?";
        return jdbcTemplate.update(sql,password,id);
    }

    @Override
    public int updateEmp(int id, double salary) throws FileNotFoundException {
        String sql = "update emp set salary=? where id=?";
//        File file = new File("c://d");
//        FileOutputStream fos = new FileOutputStream(file);
        return jdbcTemplate.update(sql,salary,id);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from user where id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int selectValue(int id) {
        String sql = "select count(1) from user where id=?";
        //如果是一个数组参数，则用queryForObject(sql,int[] arr,Integer.class),如果是一个参数，则（sql,Integer.class,id）
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }

    @Override
    public User select(int id) {
        String sql = "select * from user where id=?";
        //查询返回一个对象用queryForObject(sql,new MyRowMapper(),id)
        return jdbcTemplate.queryForObject(sql,new MyRowMapper(),id);
    }

    @Override
    public List<User> selectAll() {
        String sql = "select * from user";
        List list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public Map selectMap(int id) {
        String sql = "select username,password from user where id=?";
        Map map = jdbcTemplate.queryForMap(sql,id);
        return map;
    }
}

class MyRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        int id = resultSet.getInt("id");
        User user = new User(id,username,password);
        return user;
    }
}