package com.didi.concurrency;

public class TestThread extends  Thread {

public TestThread(String name ){


    super(name);
}

public TestThread(ThreadGroup group , String name){

    super(group, name);
}

public void run(){

    for (int i = 0 ; i<100 ;i ++){

        System.out.println(getName() + "线程的i变量" + i );
    }
}

}
