package com.example.practice.trycatchpackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultTest {

    @RequestMapping("test")
    public ResultData test(){
//       ResultData resultData = new ResultData(ErrorEnum.REQUEST_SUCCESS,"first test");
        ResultData resultData = new ResultData("成功","0001",true,"abc");
       return resultData;
   }
}
