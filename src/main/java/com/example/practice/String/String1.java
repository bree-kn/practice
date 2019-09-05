package com.example.practice.String;

import java.util.Arrays;

/**
 * replace,replaceAll：相同点是都替换所有的字符为另外一个字符，不同点是replaceAll支持正则表达式s.replaceAll("\\d", "*")
 * replaceFirst:替换第一个
 * continue; //跳过循环体中剩余语句而进入下一次循环(第3要素)
 */
public class String1 {
    public static void main(String[] args) {
        int num = 97,count=0;
        for(int j = 0;j<100;j++){
            boolean flag = true;
            for(int i = 2;i<=Math.sqrt(num);i++){
            if(j % i == 0){
                flag = false;
                break;
            }
        }
            if(flag == true){
                count++;
//            System.out.println("yes");
            }
//            else{
//                System.out.println("not");
//            }
        }

        System.out.println(count);
//        String s = "12345&12&6";
//        s = s.replaceAll("&","m");
//        s = s.replaceFirst("&","i am");
//        s = s.replace("&","aaa");
//        s = s.replaceAll("\\d", "*");
//        System.out.println(s);
//        char a = 90;
//        char c = '\\';
//        System.out.println(c);
 /*       long a = 10000000000L;
        int b = (int)a;
        System.out.println(b);
        double f = 3.0;
        double g = 2.9;
        System.out.println(f-g);
 */
/*
        int year = 2019;
        boolean flag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        if(flag == true){
            System.out.println("闰年");
        }else{
            System.out.println("平年");
        }
*/
/*
        int sum = 0; //和
        for(int i=1;i<=100;i++){
            if(i%10==3){
                break; //continue跳过循环体中剩余语句而进入下一次循环(第3要素)
            }
            sum += i;
        }
        System.out.println("sum="+sum);
*/
/*
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = Arrays.copyOf(arr,6);//从一个数组里边复制6个到另外一个数组
        int[] arr2 = new int[10];
        System.arraycopy(arr,2,arr2,0,2);//从指定位复制指定个数到另外一个数组
        arr = Arrays.copyOf(arr,arr.length+2);//扩容2个
        for(int i : arr){
            System.out.println(i);
        }
*/
    }
}
