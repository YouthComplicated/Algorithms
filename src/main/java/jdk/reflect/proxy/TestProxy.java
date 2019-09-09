package jdk.reflect.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class TestProxy {


    @Test
    public void test01(){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class}, myInvocationHandler);

        List<String> stringList = new ArrayList<String>();
        myInterface.doSomething(stringList, 123);




    }

}
