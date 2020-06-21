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

    public ServerThread2(Socket socket) {


        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br.readLine()) != null) {

                if (line.startsWith(YeekuProtocol.USER_ROUND) && line.endsWith(YeekuProtocol.USER_ROUND)) {

                    String userName = getRealMsg(line);

                    if (Server2.clients.containsKey(userName)) {

                        System.out.println("重复");
                        ps.println(YeekuProtocol.NAME_REP);


                    } else {

                        System.out.println("成功");
                        ps.println(YeekuProtocol.LOGIN_SUCCESS);
                        Server2.clients.put(userName, ps);
                    }
                } else if (line.startsWith(YeekuProtocol.PRIVATE_ROUND) && line.endsWith(YeekuProtocol.PRIVATE_ROUND)) {


                    String userAndMsg = getRealMsg(line);
                    String user = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[0];
                    String msg = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[1];
                    Server2.clients.get(user).println(
                            Server2.clients.getKeyByValue(ps) + "悄悄对你说" + msg

                    );
                } else {

                    String msg = getRealMsg(line);
                    for (PrintStream ps : Server2.clients.valueSet()) {

                        ps.println(

                                Server2.clients.getKeyByValue(ps) + "说" + msg
                        );
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


    public String getRealMsg(String line) {

        return line.substring(YeekuProtocol.PROTOCOL_LEN, line.length() - YeekuProtocol.PROTOCOL_LEN);
    }
}
