package com.didi.concurrency;

public class ThreadLocalTest {

    public static void main(String[] args) {
        Account3 account3 = new Account3("初始名");

        new MyTest(account3,"线程甲").start();
        new MyTest(account3,"线程乙").start();
    }
}
