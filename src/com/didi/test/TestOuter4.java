package com.didi.test;

public class TestOuter4 {

    public  static void main (String args[]){

        Outer4 outer4 = new Outer4();
        //Outer4.Inner inner = (Inner) outer4.test();
        Contents c = outer4.test();
        c = outer4.test2();

        //Outer4.Inner inner = (Inner)c ;

        // System.out.println(inner.a);

      //  Outer4.Inner inner1 = outer4.test2();
     //   Outer4.Inner inner2 = (Outer4.Inner) c;



    }
}
