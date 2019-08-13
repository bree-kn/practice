package com.example.practice.trycatchpackage;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理：
 * RestControllerAdvice:捕获controller层抛出的异常，返回格式为json,
 * ExceptionHandler统一处理一种类的异常，减少代码重复率，降低复杂度。
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MyException.class)
    public ResultData handlerException(HttpServletRequest request,MyException e){
//        ResultData resultData = new ResultData(ErrorEnum.REQUEST_FAIL.getMessage(),ErrorEnum.REQUEST_FAIL.getCode(),false);
        ResultData resultData = new ResultData(e.getMessage(),"0000",false);
        return resultData;
    }
}
