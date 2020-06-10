package com.didi.test;

public class Outer5 {

//Contents 必须事先存在
    public Contents contents(){
        //返回的只是Outer5内部类的引用的向上转型
        return new Contents() {
            private  int i = 123 ;
            @Override
            public int value() {

                return i ;
            }
        };
    }

    public static void  main(String args[]){

        Outer5 outer5 = new Outer5();
        Contents c = outer5.contents() ;


    }
}
