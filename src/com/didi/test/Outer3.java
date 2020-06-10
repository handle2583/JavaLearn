package com.didi.test;

public class Outer3 {


    private  String a = "didi" ;
    private  void print(){

        System.out.println( a);


    } ;

    class Inner {
        private String b = "baidu" ;

        void alter(){


            a = b ;
            print();



        }


    }

    void test(){
        Inner inner = new Inner() ;
        inner.alter();

        System.out.println(inner.b);


    }


    public static void main(String args[]){


        Outer3 outer3 = new Outer3();
        outer3.test();




    }
}
