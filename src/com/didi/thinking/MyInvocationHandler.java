package com.didi.thinking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

 class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法"+method);
        if (args!=null){

            System.out.println("下面是执行该方法时的实参:");
            for (Object val:args){

                System.out.println(val);
            }

        }
        else{

            System.out.println("调用该方法无实参");
        }
        return null ;

    }
}
