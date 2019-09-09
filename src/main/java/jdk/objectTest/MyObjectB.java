package jdk.objectTest;

import org.junit.Test;

public class MyObjectB implements Cloneable {


    public static void main(String[] args) {
    }

    @Test
    public void test01() throws CloneNotSupportedException {
        MyObjectB myObjectB = new MyObjectB();
        MyObjectB clone  = (MyObjectB) myObjectB.clone();
        System.out.println("myObjectB:"  + myObjectB.toString());
        System.out.println("myObjectBClone:"  + clone.toString());
    }
}
