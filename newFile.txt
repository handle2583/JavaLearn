package com.didi.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null ;
        FileOutputStream fos = null ;

        try {


            fis = new FileInputStream("./src/com/didi/io/FileOutputStreamTest.java");
            fos = new FileOutputStream("newFile.txt") ;
            byte[] bbuf = new byte[32];
            int hasRead = 0 ;
            while ((hasRead = fis.read(bbuf))>0 ){

                fos.write(bbuf,0,hasRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

            e.printStackTrace();
        }finally {
            if (fis != null){
                fis.close();

            }
            if (fos != null){

                fos.close();
            }
        }

    }
}
