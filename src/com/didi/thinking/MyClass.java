package com.didi.thinking;


public class MyClass {
    public MyClass() {
        System.out.println("MyClass");
    }

    public MyClass(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new MyClass();
        new MyClass("111") ;
    }
}
