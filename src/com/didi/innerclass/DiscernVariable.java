package com.didi.innerclass;

public class DiscernVariable  {

    private  String pop = "外部类属性";
    private  class Inclass{

        private  String pop = "内部类属性";
        public  void info(){

            String pop = "局部变量";
            System.out.println("外部类的属性值 :"+DiscernVariable.this.pop);
            System.out.println("内部类的属性值 :"+this.pop);
            System.out.println(pop);
        }

    }

    public void test(){

        Inclass in = new Inclass();
        in.info();
    }

    public static void main(String[] args) {
        new DiscernVariable().test();
    }
}
