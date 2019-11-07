package com.example.practice.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws ParseException {
        String endTime = "2019-10-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(endTime));
        calendar.set(Calendar.HOUR,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(sdf1.format(calendar.getTime()));
//        String time1 = sdf.format(new Date());
//        System.out.println(time1);
//        Date date = sdf.parse("2019-09-09 19:10:10");
//        System.out.println(sdf.format(date));
//        System.out.println();
    }
}
