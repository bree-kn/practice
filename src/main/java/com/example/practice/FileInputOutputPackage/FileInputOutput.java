package com.example.practice.FileInputOutputPackage;

import java.io.*;

public class FileInputOutput {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("D:\\迅税通项目\\a.txt"));
            fos = new FileOutputStream(new File("D:\\迅税通项目\\b.txt"));
            int b = 0;
            byte[] bytearr = new byte[1024];
            while((b = (fis.read(bytearr)))!=-1){
                fos.write(bytearr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                fis.close();
            }
        }

    }
}
