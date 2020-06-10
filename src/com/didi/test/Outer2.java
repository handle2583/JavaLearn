package com.didi.test;

public class Outer2 {
     public static void main(String[] args) {


         Outer outer = new Outer() ;
         Outer.Inner inner = outer.new Inner();


     }
}
