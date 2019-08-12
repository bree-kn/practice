package com.example.practice.SingletonPackage;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class SingleTest {
    public static void main(String[] args) {
/*
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
*/
        int[] arr = new int[]{10,20,30,40,50};
        int[] arr1 = new int[10];
        System.arraycopy(arr,2,arr1,0,2);
        System.out.println(Arrays.toString(arr1));
    }
}
