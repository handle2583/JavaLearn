package com.didi.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class MultiDown {

    public static long getFileLength(URL url) throws Exception {

        long length = 0;
        URLConnection con = url.openConnection();
        long size = con.getContentLength();
        length = size;
        return length;

    }


    public static void main(String[] args) {
        //下载线程的数量
        final int DOWN_THREAD_NUM = 4;
        //下载的文件的名字
        final String OUT_FILE_NAME = "down.jpg";
        //声明下载线程数个输入流数组
        InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
        //声明下载线程数个输出流数组
        RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
        try {
            //访问地址
            URL url = new URL("http://images.china-pub.com//ebook8045001-8050000/8049683/cover.jpg");
            //第一个输入流
            isArr[0] = url.openStream();
            //获取资源内容的长度
            long fileLen = getFileLength(url);

            System.out.println("网络资源的大小" + fileLen);
           //第一个输出流
            outArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
            //生成一个同大小的空文件
            for (int i = 0; i < fileLen; i++) {
                outArr[0].write(0);
            }
            //每个线程分配的大小
            long numPerThread = fileLen / DOWN_THREAD_NUM;
            //剩余大小
            long left = fileLen % DOWN_THREAD_NUM;

            for (int i = 0; i < DOWN_THREAD_NUM; i++) {
                //不是第一次 第一次已经打开流
                if (i != 0) {
                    isArr[i] = url.openStream();
                    outArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
                }
                //最后一次需要加上余下的
                if (i == DOWN_THREAD_NUM - 1) {
                    new DownThread(i * numPerThread, (i + 1) * numPerThread + left, isArr[i]
                            , outArr[i]).start();
                } else {
                    new DownThread(i * numPerThread, (i + 1) * numPerThread, isArr[i], outArr[i]).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
