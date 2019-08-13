package com.example.practice.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**当在遍历集合的时候，添加或删除元素会出现ConcurrentModificationException
 * Exception in thread "main" java.util.ConcurrentModificationException
 * 单线程的时候可以用iterator.remove()则不会报错，成功删除
 * 也可以用CopyOnWriteArrayList
 */
public class ConcurrentTest {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(10);
        list.add(20);
        list.add(5);
        for(int i : list){
            if(i==5){
                list.add(100);
            }
        }
        System.out.print(list.toString());

/*   迭代器remove
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer.intValue() == 5){
                iterator.remove();
            }
        }
        System.out.println(list.toString());
*/
    }
}
