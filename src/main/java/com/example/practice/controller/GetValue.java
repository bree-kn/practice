package com.example.practice.controller;

public class GetValue {
    private long time;
    public void updateTime(long time){
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "getValue{" +
                "time=" + time +
                '}';
    }
}
