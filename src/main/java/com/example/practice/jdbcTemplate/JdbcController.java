package com.example.practice.jdbcTemplate;

import com.example.practice.trycatchpackage.ErrorEnum;
import com.example.practice.trycatchpackage.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    @Autowired
    private JdbcService jdbcService;

    @RequestMapping("add")
    public ResultData add(@RequestBody User user){
        try {
            jdbcService.add(user);
            return new ResultData(ErrorEnum.REQUEST_SUCCESS,"插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultData(ErrorEnum.REQUEST_FAIL,"插入失败");
        }
    }
}
