package com.didi.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Accout2 {


    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private String accountNo;

    private double balance;

    private boolean flag = false;

    public Accout2() {
    }

    public Accout2(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }

    public synchronized  void draw (double drawAmount){

        try
        {
            if (!flag){

               condition.await();

            }
            else{

                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为 "+balance);
                flag = false ;
                condition.signalAll();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try{
            if (flag){

                condition.await();
            }else
            {


                System.out.println(Thread.currentThread().getName()+"存钱"+depositAmount);
                balance+= depositAmount;
                System.out.println("账户余额为"+balance);
                flag = true ;
                condition.signalAll();
            }

        }catch (InterruptedException e){

            e.printStackTrace();
        }

    }

}
