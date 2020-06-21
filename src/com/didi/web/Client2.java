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
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket("127.0.0.1", SERVER_PORT);
            //输出流
            ps = new PrintStream(socket.getOutputStream());
            //输入流
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            while (true) {

                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                System.out.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);
                ps.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);

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