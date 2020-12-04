package jdk.reflect.myproxy;

import java.lang.reflect.Proxy;

/**
 *
 *
 * @author: nj
 * @date: 2020-08-19 17:44
 * @version: 0.0.1
 */
public class Test {

    public static void main(String[] args) {

//        ChinesePerson chinese = new ChinesePerson();
        Person chinese = new ChinesePerson();
        DynamicProxy proxy = new DynamicProxy(chinese);
        /**
         * 注意返回类型是接口不是具体的类
         * Returns an instance of a proxy class for the specified interfaces
         * that dispatches method invocations to the specified invocation handler.
         */
        Person chineseProxy = (Person) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), proxy);
        chineseProxy.eat();


    }
}