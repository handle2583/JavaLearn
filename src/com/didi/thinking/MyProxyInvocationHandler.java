package com.didi.thinking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyInvocationHandler implements InvocationHandler {

    private Object target ;
    public void setTarget(Object target){
        this.target = target ;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        CatUtil cu = new CatUtil();
        cu.method1();

        Object result = method.invoke(target,args) ;

        cu.method2();

        return result;
    }
}
