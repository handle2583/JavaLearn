package com.didi.test;

public class B {

    Interface2[] array = new Interface2[3] ;
    int[] intarray;
    int i = 0 ;


    void add(Interface2 interface2){

        System.out.println(interface2);
        System.out.println(i);
        array[i] = interface2 ;
        i ++;


    }

    void clear(){
        array = null;

    }

    void list(){

        for (int j = 0 ;j< array.length ; j++){

            array[j].method1();
            array[j].method2();
            array[j].method3();


        }

    }

    public static void main(String args[]){

        B b = new B();

        A a1 = new A();
        b.add(a1.getA());
        A a2 = new A();
        b.add(a2.getA());
        A a3 = new A();
        b.add(a3.getA());


        b.list();


        b.clear();



    }
}
