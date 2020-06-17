package com.didi.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) {



        File file   = new File(".");

        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        try {
            File tempFile = File.createTempFile("aaa",".text" , file);
            tempFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newFile = new File(System.currentTimeMillis() + "");

        System.out.println("是否存在 ： "+newFile.exists());

        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        newFile.mkdir();

        String[] fileList = file.list();
        System.out.println("============当前文件夹下所有的目录===============");
        for (String fileName:fileList){

            System.out.println(fileName);

        }

        File[] roots = File.listRoots();
        System.out.println("==========系统所有的根目录============");
        for (File root:roots){
            System.out.println(root);
        }


    }
}
