package com.example.practice.controller;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        Long time = System.currentTimeMillis();
//        Long time = 1561964091000l;
        Long time = 1561877691000l;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(time);
        System.out.println(date);
        int timeYear = Integer.parseInt(date.substring(0,4));
        int timeMonth = Integer.parseInt(date.substring(5,7));
        int timeDay = Integer.parseInt(date.substring(8,10));

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        if(timeYear==year && timeMonth-1==month && timeDay==day ){
                System.out.println("是今天"+date.substring(11));
        }
        if(timeYear==year && timeMonth-1==month && day-1==timeDay) {
            System.out.println("是昨天" + date.substring(11));
        }
         if(timeYear!=year){
             System.out.println("跨年"+date);
         }
         //昨天，今天
        int yesterday = calendar.get(Calendar.DATE-1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(day);
        list.add(yesterday);
        if(!list.contains(timeDay) && timeYear==year){
            System.out.println("前两天"+date.substring(5));
        }
        }




    }
