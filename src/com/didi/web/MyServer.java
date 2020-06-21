package com.didi.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class MyServer {


    public static ArrayList<Socket> sockets = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket(30000);
       //接收客户端的请求 添加至ArrayList 启动服务器线程
        while (true) {
            Socket s = ss.accept();
            sockets.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
