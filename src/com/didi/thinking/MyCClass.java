package com.didi.thinking;

public class MyCClass {
    public MyCClass(){

        System.out.println("MyCClass");
    }
    public MyCClass(int i) {
        System.out.println("MyCClass int i " + i);

    }


    public MyCClass(int i, String s) {
        //this(i);
        this();
        System.out.println("MyCClass int String ");
        System.out.println(i);
        System.out.println(s);
    }


    public static void main(String[] args) {

        new MyCClass(1, "hah");

    }
}
