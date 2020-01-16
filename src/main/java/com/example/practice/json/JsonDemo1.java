package com.example.practice.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo1 {
    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "br");
        obj1.put("age", "20");
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "st");
        obj2.put("age", "20");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(obj1);
        jsonArray.add(obj2);
        JSONObject obj = new JSONObject();
        obj.put("data", jsonArray);
        obj.put("message", "test json");
        List<String> list = new ArrayList<>();
        list.add("aaaaaa");
        list.add("bbbbbb");
        list.add("cccccc");
        obj.put("list", list);
        System.out.println(obj.toJSONString());
/*
        String s = "{\"data\":[{\"name\":\"br\",\"age\":\"20\"},{\"name\":\"st\",\"age\":\"20\"}],\"message\":\"test json\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        String message = jsonObject.getString("message");
        System.out.println(message);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            String name = obj.getString("name");
            String age = obj.getString("age");
            System.out.println("name:"+name+",age:"+age);

        }
*/
    }
}
