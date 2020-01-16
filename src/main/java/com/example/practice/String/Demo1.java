package com.example.practice.String;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * isNotEmpty不为空即可“12”，“  ”
 * ""为empty，也为black
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
//        for(: map.entrySet()){
//
//        }
/*        String str1 = "";
        if(str1 != null || str1.length() == 0){
            System.out.println("aaa");
        }*/
/*        String str = "1";
        System.out.println(str.length());
        if(StringUtils.isNotEmpty(str)){
            System.out.println("不为empty");
        }
        if(StringUtils.isNotBlank(str)){
            System.out.println("不为null");
        }
        if(StringUtils.isEmpty(str)){
            System.out.println("为empty");
        }
        if(StringUtils.isBlank(str)){
            System.out.println("为black");
        }
        System.out.println("done");*/
    }
}
