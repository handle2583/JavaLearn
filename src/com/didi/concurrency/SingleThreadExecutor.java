package com.didi.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {



    public static void main(String[] args) {


        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0 ;i<5 ; i++){

            executorService.execute(new LiftOff(5));

        }
        executorService.shutdown();

    }
}
