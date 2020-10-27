package com.didi.thinking;

public class StaticClassTest {

    static int a = 1 ;

    static int b =2;
    static {
        System.out.println("b = "+b);
        b = 3;
        System.out.println("b = "+b);

    }
   public  static void test(){
       System.out.println("a = "+a);
       System.out.println("b = "+b);


    }

    public static void main(String[] args) {

       StaticClassTest.test();
    }
}
