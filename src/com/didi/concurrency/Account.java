package com.didi.concurrency;


public class Account {

    private String accountNo;

    private double balance;

    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
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

                wait();

            }
            else{

                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为 "+balance);
            flag = false ;
            notifyAll();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try{
            if (flag){

                wait();
            }else
            {


                System.out.println(Thread.currentThread().getName()+"存钱"+depositAmount);
                balance+= depositAmount;
                System.out.println("账户余额为"+balance);
                flag = true ;
                notifyAll();
            }

        }catch (InterruptedException e){

            e.printStackTrace();
        }

    }
}
