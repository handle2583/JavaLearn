package com.didi.concurrency;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {


        int i = 0;
        for (; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + " 的循环变量i " + i);


        }
        return i;
    }
}
