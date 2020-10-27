package com.didi.thinking;

public class MyThis {

    public void test1(){

        System.out.println("test1");
        test2();
        this.test2();

    }

    public void test2(){

        System.out.println("test2");
    }

    public static void main(String[] args) {
        MyThis myThis = new MyThis();

        myThis.test1();
    }
}
