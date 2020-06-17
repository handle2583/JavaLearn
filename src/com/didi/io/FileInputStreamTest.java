package com.didi.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {


    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/com/didi/io/FileInputStreamTest.java");
       byte[] bbuf = new byte[1024] ;
       int hasRead = 0 ;
       while ((hasRead =fis.read(bbuf))>0){

           System.out.println(new String(bbuf,0,hasRead));

       }
       fis.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
