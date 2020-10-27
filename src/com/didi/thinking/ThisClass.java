package com.didi.thinking;

public class ThisClass {

    void peel(int i){
        System.out.println(this.toString());
        System.out.println(i);
    }

    public static void main(String[] args) {
        ThisClass thisClass1 = new ThisClass(),
                thisClass2 = new ThisClass();

        thisClass1.peel(1);
        thisClass2.peel(2);
    }
}
