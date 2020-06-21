package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread2 extends Thread {

    BufferedReader br = null;
   //
    public ClientThread2(BufferedReader br) {

        this.br = br;

    }

    @Override
    public void run() {
        try {
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
