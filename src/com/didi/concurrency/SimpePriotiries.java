package com.didi.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpePriotiries implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priorities;

    public SimpePriotiries(int priorities) {
        this.priorities = priorities;

    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {

        Thread.currentThread().setPriority(priorities);
        while (true) {

            for (int i = 1; i < 10000; i++) {


                d += (Math.PI + Math.E) / (double) i;
                if (i % 100 == 0) {

                    Thread.yield();
                }

                System.out.println(this);
                if (--countDown == 0) {
                    return;
                }
            }
        }

    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {

            executorService.execute(new SimpePriotiries(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimpePriotiries(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
