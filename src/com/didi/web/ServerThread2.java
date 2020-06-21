package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread2 extends Thread {

    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;

    //构造器获得socket
    public ServerThread2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //相对服务器输入流 = 客户端的输出流 就是客户端发送给服务器的内容
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //输出流
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            //读取服务器输入流的内容
            while ((line = br.readLine()) != null) {
                //如果内容是以USER_ROUND 开始和结束
                if (line.startsWith(YeekuProtocol.USER_ROUND) && line.endsWith(YeekuProtocol.USER_ROUND)) {
                    System.out.println("用户");
                    System.out.println(line);
                    String userName = getRealMsg(line);
                    //是否已经存在于list
                    if (Server2.clients.containsKey(userName)) {
                        System.out.println("重复");
                        ps.println(YeekuProtocol.NAME_REP);

                    } else {
                        System.out.println("成功");
                        //服务器输出流成功
                        ps.println(YeekuProtocol.LOGIN_SUCCESS);
                        //加入list
                        Server2.clients.put(userName, ps);
                    }
                    //内容以PRIVATE_ROUND开始和结束
                } else if (line.startsWith(YeekuProtocol.PRIVATE_ROUND) && line.endsWith(YeekuProtocol.PRIVATE_ROUND)) {

                    System.out.println("私密");
                    //区分用户名和内容
                    String userAndMsg = getRealMsg(line);
                    String user = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[0];
                    String msg = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[1];
                    Server2.clients.get(user).println(
                            Server2.clients.getKeyByValue(ps) + "悄悄对你说" + msg
                    );
                } else {
                    System.out.println("公告");
                    System.out.println(line);
                    String msg = getRealMsg(line);
                    for (PrintStream psVal : Server2.clients.valueSet()) {
                        System.out.println(ps);
                        System.out.println(Server2.clients.getKeyByValue(ps));
                        if (psVal == ps){

                            ps.println(
                                    Server2.clients.getKeyByValue(ps) + "说" + msg
                            );
                        }

                    }
                }
            }
        } catch (IOException e) {
            Server2.clients.removeByValue(ps);
            System.out.println(Server2.clients.size());

            try {
                if (br != null) {
                    br.close();
                }
                if (ps != null) {

                    ps.close();
                }
                if (socket != null) {

                    socket.close();
                }
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
    }

    //去掉首尾的标识
    public String getRealMsg(String line) {
        return line.substring(YeekuProtocol.PROTOCOL_LEN, line.length() - YeekuProtocol.PROTOCOL_LEN);
    }
}
