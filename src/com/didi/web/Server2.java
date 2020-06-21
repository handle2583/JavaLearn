package com.didi.web;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    private static final  int SERVER_PORT = 30000;
    public  static YeekuMap<String , PrintStream> clients = new YeekuMap<String, PrintStream>();

    public void init(){
        ServerSocket ss = null ;
        try{
            ss = new ServerSocket(SERVER_PORT);
            while (true){
                Socket s = ss.accept();
                new ServerThread2(s).start();
            }
        }catch (IOException e){
            System.out.println("服务器 启动失败，是否端口" +SERVER_PORT+"已被占用");
            e.printStackTrace();
        }finally {
            try{

                if (ss!=null){

                    ss.close();
                }
            }catch (IOException e){

                e.printStackTrace();
            }
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        Server2 server2 = new Server2();
        server2.init();
    }
}
