package com.example.practice.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Math.random()-> 0-1
 * Random.nextInt(n)-> 0-n
 */
public class DeleteDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = 10;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println("before sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        Arrays.sort(arr);
        System.out.println("after sort");
        for (int i : arr) {
            System.out.print(i + "\t");
        }

        System.out.println();
        System.out.println("please input delete num");
        int num = scan.nextInt();

/* 顺序查找
        int deleteIndex = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num){
                System.out.println("find it");
                deleteIndex = i;
                break;
            }
        }

        if(deleteIndex == -1){
            System.out.println("not find it");
            System.exit(0);
        }else{
            System.out.println("find it,need delete it");
        }
        System.out.println(num);
*/
//下边是二分查找的代码
        int deleteIndex = -1;
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(num < arr[mid]){
                high = mid-1;
            }else if(num > arr[mid]){
                low = mid+1;
            }else{
                System.out.println("find it");
                deleteIndex = mid;
                break;
            }
        }
        if(deleteIndex == -1){
            System.out.println("not found it");
            System.exit(0);
        }

        System.out.println("开始删除");
        int count = arr.length;
        count--;
        for(int i = deleteIndex;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        for(int i=0;i<count;i++){
            System.out.print(arr[i]+"\t");
        }


    }
}
