package com.didi.thinking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args)throws  Exception {

        InvocationHandler invocationHandler = new MyInvocationHandler();

        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader()
        ,new Class[]{Person.class},invocationHandler) ;

        p.walk();
        p.sayHello("斗战胜佛");
    }
}
