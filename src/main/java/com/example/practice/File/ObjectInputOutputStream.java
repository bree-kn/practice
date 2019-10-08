package com.example.practice.File;

import com.example.practice.jdbcTemplate.User;
import com.example.practice.jdbcTemplate.emp;

import java.io.*;

/**
 * 序列化：对象转换为字节序列的过程保存在内存，文件，数据库中，ObjectOutputStream的writeObject方法可以实现序列化。
 * 反序列化：字节序列转换为对象，ObjectInputStream的readObject方法可以实现反序列化。
 */
public class ObjectInputOutputStream {
    public static void main(String[] args) throws Exception {
      try{
        System.out.println(1/0);
      }catch (Exception e){
//          throw new Exception("error le");
          throw e;
      }
/*
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\newtest.txt")));
        emp e = new emp(99,"aa","44",99);
        oos.writeObject(e);
        oos.close();
*/

/*
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\newtest.txt")));
        emp e1 = (emp)ois.readObject();
        System.out.println(e1.toString());
*/
    }
}
