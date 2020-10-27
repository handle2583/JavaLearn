package com.didi.thinking;

public class MyStaticClass {
    static int i =1 ;

    static{

        System.out.println("static block i = " +i);
        i = 2 ;
    }

    public MyStaticClass(){

        System.out.println("constructor i ="+i);
        i= 10;
        System.out.println("constructor i ="+i);
    }

    public static void main(String[] args) {
        new MyStaticClass();
    }
}
