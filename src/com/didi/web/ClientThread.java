package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket s;

    BufferedReader br = null;
   //构造器 获取Socket  获取输入流 对客户端线程来说 输入流是主线程获取的键盘输入的内容
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {

        try {
            String content = null;
            while ((content = br.readLine()) != null) {
                //输出键盘输入的内容
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
