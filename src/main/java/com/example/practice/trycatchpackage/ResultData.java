package com.example.practice.trycatchpackage;

import java.util.LinkedList;

/**
 * 全局返回对象类型：
 * 有时需要从后端返回内容给前端，有好几个字段如时间，是否成功，内容等，
 * 则需要将其封装为一个类，创建对象，并传值给这个对象，将其返回去即可。
 */
public class ResultData<T> {
    private String msg;
    private String rtncode;
    private boolean status;
    private Long ts;
    private T data;

    //添加无参构造方法，否则报错在反序列化的时候
    public ResultData() {
    }

    //3个参数
    public ResultData(String msg, String rtncode, boolean status) {
        this.msg = msg;
        this.rtncode = rtncode;
        this.status = status;
        this.ts = System.currentTimeMillis();
        this.data = (T)new LinkedList();
    }
//4个参数
    public ResultData(String msg, String rtncode, boolean status, T data) {
        this.msg = msg;
        this.rtncode = rtncode;
        this.status = status;
        this.ts = System.currentTimeMillis();
        if(null != data){
            this.data = data;
        }else {
            this.data = (T)new LinkedList();
        }
    }
    public ResultData(ErrorEnum errorEnum,T data){
        this(errorEnum.getMessage(),errorEnum.getCode(),errorEnum.isStatus(),data);
    }
    public String getMsg() {
        return msg;
    }

    public String getRtncode() {
        return rtncode;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getTs() {
        return ts;
    }

    public T getData() {
      return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRtncode(String rtncode) {
        this.rtncode = rtncode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public void setData(T data) {
        if(null != data){
            this.data = data;
        }else {
            this.data = (T)new LinkedList();
        }
    }
}
