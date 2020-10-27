package com.didi.thinking;

public class MyFClass {

    @Override
    protected void finalize(){

        System.out.println("finalize() is called");
    }

    public static void main(String[] args) {
        new MyFClass();
        System.gc();
        System.runFinalization();
    }
}
