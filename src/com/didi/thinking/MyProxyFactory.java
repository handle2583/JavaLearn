package com.didi.thinking;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
    public static Object getProxy(Object target) throws  Exception{

        MyProxyInvocationHandler invocationHandler = new MyProxyInvocationHandler();
        invocationHandler.setTarget(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),invocationHandler) ;

    }

}


