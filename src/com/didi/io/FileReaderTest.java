package com.didi.io;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {


    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("./src/com/didi/io/FileReaderTest.java");
            char[] cbuf = new char[32];

            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {

                System.out.print(new String(cbuf, 0, hasRead));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {

                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
