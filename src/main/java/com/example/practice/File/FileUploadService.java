package com.example.practice.File;

import com.example.practice.trycatchpackage.ResultData;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {
    public ResultData upload(HttpServletRequest request, String imageFileCount);

    public ResultData storeToLocal(HttpServletRequest request, String imageFileCount);

    public ResultData getNonParam();

    public ResultData getHaveParam(String name,int age);

    public ResultData getHaveParamHeader(HttpServletRequest request, @RequestHeader(value = "token")String token, String name);

    public ResultData postNoParam(HttpServletRequest request,@RequestHeader(value = "token")String token);

    public ResultData postHaveParam(HttpServletRequest request,@RequestHeader(value = "token")String token,String name);
}
