package com.didi.factory;

public class Factory {


    public static void serviceConsumer(ServiceFactory fact){

        Service s = fact.getService();
        s.method1();
        s.method2();


    }

    public static void main(String args[]){

        //处理供应商接口
        serviceConsumer(Imp1.factory);



        //处理客户接口
        serviceConsumer(Imp2.factory);


    }
}
