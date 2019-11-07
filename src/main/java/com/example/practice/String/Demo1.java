package com.example.practice.String;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * isNotEmpty不为空即可“12”，“  ”
 * ""为empty，也为black
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) {
        String str = "1";
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
        System.out.println("done");
    }
}
