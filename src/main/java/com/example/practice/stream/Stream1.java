package com.example.practice.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.什么是流：流是支持数据处理操作的源生成的元素序列，源可以是数组，文件，集合，函数，流不是集合，它不是数据结构不保存数据，用于计算。
 *  2.流的操作类型2中：
 *  (1)中间操作一个流可以后面跟随两个或多个中间操作，目的是打开流，做出数据映射或过滤，然后返回一个新的流，交给下一个操作使用，真正的遍历
 *  需等到终端操作时，常见的中间操作有filter,map等。
 *  (2)终端操作一个流有且只能有一个终端操作，当这个操作执行后，流就被关闭了，因此一个流只能被遍历一次。终端操作的执行，才会真正开始流的遍历。
 *
 */
public class Stream1 {
    public static void main(String[] args) throws IOException {
/*        //生成流的方式
        //1.通过集合
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        System.out.println(integerList);
        Stream<Integer> stream = integerList.stream();
        //2.通过数组生成
        int[] intArr = new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(intArr);
        //3.通过值生成
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        //4.通过文件生成
        Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());//得到的每个流是给定文件中的一行。
 */
/*
        List<Integer> list = Arrays.asList(1,3,1,356,8);
        List list1 = list.stream().filter(i -> i > 3).collect(Collectors.toList());
        System.out.println(list1);
*/
        List<Integer> list = Arrays.asList(77,1,1,3,4,2);
//        long count = list.stream().distinct().count();//计数
//        System.out.println(count);
//        System.out.println(list.stream().limit(3).collect(Collectors.toList()));//返回指定流个数
        System.out.println(list.stream().skip(4).collect(Collectors.toList()));//跳过前4个元素
        //map流映射，流映射是将接受的元素映射成另外一个元素
        List<String> stringList = Arrays.asList("abc","def","m","ei");
        Stream<Integer> stream = stringList.stream().map(String::length);
    }
}
