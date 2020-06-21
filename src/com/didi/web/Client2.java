package com.didi.web;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;

    public void init() {
        try {
            //从键盘获取输入流 针对于主线程 客户端的输入就是输入流
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            //建立socket
            socket = new Socket("127.0.0.1", SERVER_PORT);
            //输出流
            ps = new PrintStream(socket.getOutputStream());
            //输入流
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            while (true) {
                //输入框获取用户名
                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                System.out.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);
                //输出流中 USER_ROUND+用户名 + USER_ROUND
                ps.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);
                //读取服务端返回的结果  对于客户端来说是输入流
                String result = brServer.readLine();
                if (result.equals(YeekuProtocol.NAME_REP)) {
                    tip = "用户名重复！请重新输入";
                    continue;
                }

                if (result.equals(YeekuProtocol.LOGIN_SUCCESS)) {

                    break;
                }
            }
        } catch (UnknownHostException exception) {

            System.out.println("找不到远程服务器 ");
            closeRs();
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("网络异常");
            closeRs();
            System.exit(1);
        }
        new ClientThread2(brServer).start();
    }

    private void readAndSend() {

        try {
            String line = null;
            while ((line = keyIn.readLine()) != null) {
                if (line.indexOf(":") > 0 && line.startsWith("//")) {
                    line = line.substring(2);
                    ps.println(YeekuProtocol.PRIVATE_ROUND + line.split(":")[0] + YeekuProtocol.SPLIT_SIGN + line.split(":")[1] + YeekuProtocol.PRIVATE_ROUND);
                } else {

                    ps.println(YeekuProtocol.MSG_ROUND + line + YeekuProtocol.MSG_ROUND);
                }
            }
        } catch (IOException e) {

            System.out.println("网络通信异常");
            closeRs();
            System.exit(1);
        }
    }

    private void closeRs() {

        try {
            if (keyIn != null) {

                ps.close();
            }
            if (brServer != null) {
                ps.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (socket != null) {

                keyIn.close();
            }
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client2 client2 = new Client2();
        client2.init();
        client2.readAndSend();
    }
}