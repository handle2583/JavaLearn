package com.didi.nestclass;

public interface interface1 {

    void method1();

    public static class  Nestclass implements interface1{


        static void print(Nestclass nestclass){

            Nestclass nestclass1 = new Nestclass();
             nestclass1.method1();

            System.out.println(nestclass);

        }

        @Override
        public void method1() {
            Nestclass nestclass = new Nestclass() ;
            System.out.println("method1");
        }
    }
}
