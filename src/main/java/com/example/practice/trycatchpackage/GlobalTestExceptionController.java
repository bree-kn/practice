package com.example.practice.trycatchpackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalTestExceptionController {

    @RequestMapping("testError")
    public ResultData test1() throws MyException {
        throw new MyException("我是自定义异常");
    }
}
