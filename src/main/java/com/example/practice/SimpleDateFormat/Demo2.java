package com.example.practice.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  获取相应日期前一天的字符串日期，格式为：年-月-日
 */
public class Demo2 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE)-1;
        calendar.set(Calendar.DATE,day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(calendar.getTime());
        System.out.println(time);
    }
}
