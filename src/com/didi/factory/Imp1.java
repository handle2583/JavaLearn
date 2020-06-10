package com.didi.factory;


//供应商接口
public class Imp1 implements Service {

    private Imp1() {
    }


    //创建供应商
    @Override
    public void method1() {
        System.out.println("Imp1.method1");
    }


    //更新供应商
    @Override
    public void method2() {
        System.out.println("Imp1.method2");
    }

    //获得供应商接口的实例
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Imp1();
        }
    };
}
