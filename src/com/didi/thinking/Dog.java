package com.didi.thinking;

public class Dog {

    public void bark(int i  , String a ){

        System.out.println("barking");

    }

    public void bark(String a , int i ){

        System.out.println("howling");

    }

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.bark(1,"hah");
        dog.bark("haha" , 2);
    }
}
