package com.didi.concurrency;

public class Account3 {


    private ThreadLocal<String> name = new ThreadLocal<String>();


    public Account3(String name ){

        this.name.set(name);

        System.out.println("---------"+this.name.get());
    }

    public String getName(){

        return  name.get()
    ;}

    public void setName(String name){

        this.name.set(name);
    }
}
