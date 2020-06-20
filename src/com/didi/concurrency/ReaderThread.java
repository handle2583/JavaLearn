package com.didi.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class ReaderThread extends Thread {

    private PipedReader pr;

    private BufferedReader br;

    public ReaderThread() {
    }

    public ReaderThread(PipedReader pr) {

        this.pr = pr;
        this.br = new BufferedReader(pr);
    }


    public void run() {

        String buf = null;
        try {

            while ((buf = br.readLine()) != null) {
                System.out.println("读------------------------");

                System.out.println(buf);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (br != null) {

                    br.close();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
