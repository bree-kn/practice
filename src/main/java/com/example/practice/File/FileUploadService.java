package com.example.practice.File;

import com.example.practice.trycatchpackage.ResultData;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {
    public ResultData upload(HttpServletRequest request, String imageFileCount);

    public ResultData storeToLocal(HttpServletRequest request, String imageFileCount);
}
