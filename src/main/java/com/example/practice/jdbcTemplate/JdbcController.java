package com.example.practice.jdbcTemplate;

import com.example.practice.trycatchpackage.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

/**
 * 一：用requestBody的话，如果postman来发请求，有时可能会提示各种not supported，解决方法：
 * 1.把postman上的content type改为application/json,用raw,不用form-data
 * 2.加入jackson-databind依赖包
 * 二：keyHolder.getKey().toString()获取自动生成的id值
 * 三:jdbcTemplate操作数据库：
 * 增删改：jdbcTemplate.update(sql,params)
 * 查询返回一个值：Integer count = jdbcTemplate.queryForObject(sql,Integer.class,param);如果是一个参数把参数放在最后边，如果是参数数组，放在中间。
 * 查询返回一个map：Map map = jdbcTemplate.queryForMap(sql,id);
 * 查询返回一个对象：User user = jdbcTemplate.queryForObject(sql,new MyRowMapper(),id);
 * 查询返回一个集合：List<User> list = jdbcTemplate.query(sql,new MyRowMapper(),id);
 *                或者： List list = jdbcTemplate.queryForList(sql);
 */
@RestController
public class JdbcController {

    @Autowired
    private JdbcService jdbcService;

    //insert
    //自动生成id插入。
    @RequestMapping("/add")
    public ResultData add(@RequestBody User user){
            ResultData resultData = jdbcService.add(user);
            return resultData;
    }

    //update
    @RequestMapping("update")
    public ResultData update(@RequestParam(value = "id") int id,@RequestParam(value = "password") String password) throws FileNotFoundException {
        ResultData resultData = jdbcService.update(id,password);
        return resultData;
    }

    //delete
    //postman中url是http://localhost:8080/delete/2
    @RequestMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") int id){
        ResultData resultData = jdbcService.delete(id);
        return resultData;
    }

    //select->返回一个值
    @RequestMapping("/selectId/{id}")
    public ResultData selectValue(@PathVariable("id") int id){
        ResultData resultData = jdbcService.selectValue(id);
        return resultData;
    }

    //select->返回一个对象
    @RequestMapping("/select/{id}")
    public ResultData select(@PathVariable("id") int id){
        ResultData resultData = jdbcService.select(id);
        return resultData;
    }

    //select->返回集合
    @RequestMapping("/selectAll")
    public ResultData selectAll(){
        ResultData resultData = jdbcService.selectAll();
        return resultData;
    }

    //select->返回map
    @RequestMapping("/selectMap/{id}")
    public ResultData selectMap(@PathVariable int id){
        ResultData resultData = jdbcService.selectMap(id);
        return resultData;
    }
}
