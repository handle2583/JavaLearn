package com.didi.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedCommunicationTest {

    public static void main(String[] args) {

        PipedWriter pw = null;
        PipedReader pr = null;
        try {


            pw = new PipedWriter();
            pr = new PipedReader();

            pw.connect(pr);

            new WriteThread(pw).start();
            new ReaderThread(pr).start();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
