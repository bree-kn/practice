package com.example.practice.array;

import java.util.*;

/**
 * 1.Math.random()-> 0-1之间的小数
 * Random.nextInt(n)-> 0-n
 * Random random = new Random(100)，按照random.nextInt(200)这个值
 * 2.Arrays.toString(arr)可以直接输出数组的内容，平时arr.tostring()只会输出地址，所以sout(Arrays.toString(arr))即可不用写for循环来遍历数组了。
 *
 */
public class DeleteDemo {
    public static void main(String[] args) {
        Random random = new Random(100);
        System.out.println(random.nextInt(200));//小于200的数
//        Random random = new Random();
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<10;i++){
//            list.add(random.nextInt(100));
//        }
//        System.out.println(list.toString());
/*
        int[] arr = new int[10];
        Random random = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
*/
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+"\t");
//        }




/*
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

*/
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
*//*

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

*/

    }
}
