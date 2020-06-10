package com.didi.factory;


//客户接口
public class Imp2 implements Service {

    private Imp2() {
    }


    //创建客户
    @Override
    public void method1() {
        System.out.println("Imp2.method1");
    }


    //更新客户
    @Override
    public void method2() {
        System.out.println("Imp2.method2");
    }


    //获得客户接口的实例
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Imp2();
        }
    };
}
