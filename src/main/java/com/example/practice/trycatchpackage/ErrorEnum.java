package com.example.practice.trycatchpackage;

public enum  ErrorEnum {
    REQUEST_SUCCESS("0000","请求成功",true),
    REQUEST_FAIL("0001","请求失败",false),
    REQUEST_TIMEOUT("0002","请求超时",false);
    private String code;
    private String message;
    private boolean status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    ErrorEnum(String code, String message, boolean status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
