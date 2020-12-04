package jdk.reflect.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: nj
 * @date: 2020-08-19 17:40
 * @version: 0.0.1
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------调用方法前---------");
        Object result = method.invoke(target, args);
        System.out.println("--------调用方法后---------");
        return result;
    }
}