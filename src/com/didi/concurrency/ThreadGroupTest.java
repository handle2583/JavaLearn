package com.didi.concurrency;

public class ThreadGroupTest {

    public static void main(String[] args) {

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程的名称" + mainGroup.getName());

        System.out.println("是否是后台线程组" + mainGroup.isDaemon());

        new TestThread("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);

        System.out.println("tg线程组是否是后台线程组" + tg.isDaemon());

        TestThread testThread = new TestThread(tg, "tg组的线程甲");
        testThread.start();
        new TestThread(tg, "tg组的线程乙").start();

    }
}
