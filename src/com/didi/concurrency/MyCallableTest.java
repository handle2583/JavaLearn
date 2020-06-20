package com.didi.concurrency;

import java.util.concurrent.FutureTask;

public class MyCallableTest {

    public static void main(String[] args) {
    //新建Callable类 并实现该类 然后用FutureTask包装
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);

        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + " 循环变量 i" + i);

            if (i == 20) {

                new Thread(futureTask, "有返回值的线程").start();
            }
        }
        try {

            System.out.println("子线程的返回值" + futureTask.get());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
