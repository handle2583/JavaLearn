package com.didi.io;

import java.io.File;

public class FilenameFilter {


    public static void main(String[] args) {

        File file = new File(".");

        String[] nameList = file.list(new MyFilenameFilter());

        for (String name:nameList){

            System.out.println(name);
        }
    }
}
