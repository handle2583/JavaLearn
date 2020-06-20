package com.didi.concurrency;

public class MyTest extends  Thread {

    private  Account3 account3 ;

    public MyTest(Account3 account3 ,String name){

        super(name);
        this.account3 = account3 ;
    }

    public void run(){

        for (int i = 0 ;i<10 ; i++){

            if (i ==6){

                account3.setName(getName());
            }

            System.out.println(account3.getName() + "账户的i值 " + i);
        }
    }
}
