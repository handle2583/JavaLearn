package com.didi.thinking;

public class MyArrayClass {
    public MyArrayClass(String s){

        System.out.println("constructor:"+s);
    }



    public void test(String ... strings){

        for (String s:strings){
            System.out.println("test:"+s);
        }
    }

    //public static void main(String[] args) {
//        String[] a = new String[] {"I" ,"am","a","Chinese"};
//        for (String s:a){
//            System.out.println(s);
      //  }
//        MyArrayClass[] b = new MyArrayClass[]{new MyArrayClass("I") ,
//                new MyArrayClass("am") ,
//                new MyArrayClass("a") ,
//                new MyArrayClass("Chinese") ,
//        };


//        MyArrayClass myArrayClass = new MyArrayClass("hah");
//
//        myArrayClass.test("I","am","a","Chinese");
//        String[] a = new String[]{"I" , "am" , "a" ,"Chinese"} ;
//        myArrayClass.test(a);
//
//    }
public static void main(String ... args) {

        for (String a:args ) {

            System.out.println(a);
        }

}
}
