package com.didi.test;

public class Outer {


    private String outer = "outer class" ;


    class Inner{
        private String inner = "inner class" ;


        class Inner2{

            private String inner2 = "inner2 class" ;



            void inner2_print(){

                System.out.println(Inner.this.inner);

                System.out.println(inner2);
                System.out.println(inner);
                System.out.println(outer);

            }


        }


    }

    public static void main(String[] args){

        Outer.Inner.Inner2 inner2 = new Outer().new Inner().new Inner2();
        inner2.inner2_print();





    }
}
