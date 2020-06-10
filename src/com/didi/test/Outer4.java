package com.didi.test;

public class Outer4 {


    private class Inner implements Contents {
        private int a = 1;

        @Override
        public int value() {
            System.out.println(a);
            return a;
        }
    }


    Contents test() {

        return new Inner();


    }

    Inner test2() {

        return new Inner();
    }

    public static void main(String args[]) {


        Outer4 outer4 = new Outer4();
        //Outer4.Inner inner = (Inner) outer4.test();
        Contents c = outer4.test();
        c = outer4.test2();

        //Outer4.Inner inner = (Inner)c ;

        // System.out.println(inner.a);

        Inner inner1 = outer4.test2();
        Inner inner2 = (Inner) c;
    }

}




