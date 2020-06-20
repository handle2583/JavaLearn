package com.didi.concurrency;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteThread extends Thread {


    String[] books = new String[]{

            "Strust2",
            "ROR",
            "J2EE",
            "Ajax"

    };

    private PipedWriter pw;

    public WriteThread() {
    }

    public WriteThread(PipedWriter pw) {

        this.pw = pw;

    }

    public void run() {

        try {
            for (int i = 0; i < 100; i++) {

                System.out.println("写------------------------");
                pw.write(books[i % 4] + "\n");
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {

                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
