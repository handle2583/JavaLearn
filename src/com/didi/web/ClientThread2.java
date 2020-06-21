package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread2 extends Thread {

    BufferedReader br = null;
   //
    public ClientThread2(BufferedReader br) {

        this.br = br;

    }
    //传给本线程的输入流
    @Override
    public void run() {
        try {
            //读取传入本线程的输入流
            String line = null;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (br != null) {

                    br.close();
                }
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    }
}
