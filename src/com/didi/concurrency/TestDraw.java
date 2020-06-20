package com.didi.concurrency;

public class TestDraw {


    public static void main(String[] args) {

        Account account = new Account();
        new DrawThread("取钱者",account , 800).start();
        new DepositThread("存款者甲",account,800).start();
        new DepositThread("存款者乙",account,800).start();
        new DepositThread("存款者丙",account,800).start();
    }
}
