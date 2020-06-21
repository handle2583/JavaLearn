package com.didi.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 30000);
        //获取键盘输入的线程 开启 一直监控键盘的输出流-->线程的输入流
        new Thread(new ClientThread(s)).start();
        //输出流 就是键盘的输入内容
        PrintStream ps = new PrintStream(s.getOutputStream());

        String line = null;

        //将键盘的内容作为输入流 打印出来 JAVA代表标准输入 即键盘输入 但这个标准流是InputStream的实例 使用不太方便 而且我们知道键盘的输入都是文本内容

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((line = br.readLine()) != null) {
            //将键盘输入读取后的内容 作为输出流 给服务端
            System.out.println("客户端输入"+line);
            ps.println(line);
        }
    }
}
