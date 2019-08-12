package com.example.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
//        String[] arr = new String[]{"aa","bb","cc","dd","ee"};
//        for(int i=0;i<arr.length;i++){
//            Map<String,String> map = new HashMap<>();
//            map.put("test",arr[i]);
//            list.add(map);
//        }
        List<Map<String,String>> listMap = new ArrayList<>();
//        for(SearchKeywordDTO searchKeywordDTO : list){
            Map<String,String> map = new HashMap<>();
            map.put("CallName","aa");
            map.put("DisplayName","bb");
            listMap.add(map);
//        }
        System.out.println(listMap);





        System.out.println(list);
    }
}
