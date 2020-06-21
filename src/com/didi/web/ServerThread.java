package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {


    Socket s = null;

    BufferedReader br = null;
  //构造器 获取Socket 获取输入流（相对于服务端来说 客户端发出的输出流 就会被服务端的输入流获取到 ）获取BufferReader对象
    public ServerThread(Socket s) throws IOException {

        this.s = s;

        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }


    @Override
    public void run() {

        try {

            String content = null;
            while ((content = readFromClient()) != null) {
                for (Socket s : MyServer.sockets) {
                    //遍历所有的socket 然后在输出流打印内容 服务器是输出流 被客户端接收到就是输入流
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    System.out.println("这是服务端输出的内容 "+content);
                    ps.println("服务器端："+content);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private String readFromClient() {

        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.sockets.remove(s);
            e.printStackTrace();
        }
        return null;
    }
}
