package com.example.practice.comparabel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComparDemo1{
    public static void main(String[] args) {
        List<yonghu> list = new ArrayList();
        list.add(new yonghu("ar",19));
        list.add(new yonghu("cr",30));
        list.add(new yonghu("br",19));
        list.add(new yonghu("dr",40));
        list.add(new yonghu("br",60));
        Collections.sort(list);
        System.out.println(list);
    }
}
@Data
@AllArgsConstructor
class yonghu implements Comparable<yonghu>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(yonghu o) {
        if(this.name.compareTo(o.name) < 0){
            return -1;
        } else if(this.name.compareTo(o.name) > 0 ){
            return 1;
        }else{
            return this.age-o.age;
        }
    }
}