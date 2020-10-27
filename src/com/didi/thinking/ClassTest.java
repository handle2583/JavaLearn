package com.didi.thinking;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
@SuppressWarnings(value = "unchecked")
@Deprecated
public class ClassTest {

    private ClassTest(){

    }
    public ClassTest(String name ){

        System.out.println("执行有参数的构造器");
    }

    public void info(){

        System.out.println("执行无参数的info方法");
    }

    public void info(String str){
        System.out.println("执行有参数的info方法"+"，参数值"+str);
    }

    class Inner{}


    public static void main(String[] args) throws Exception {
        Class<ClassTest> clazz = ClassTest.class  ;

        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的构造器如下：");
        for (Constructor c:constructors){

            System.out.println(c);
        }
        Constructor[] publicConstructors = clazz.getConstructors();
        System.out.println("ClassTest的全部public构造器如下：");
        for (Constructor c :constructors){

            System.out.println(c);
        }

        Method[] methods = clazz.getMethods();
        System.out.println("ClassTest的全部public方法如下：");
        for (Method md:methods){

            System.out.println(md);
        }



    }
}
