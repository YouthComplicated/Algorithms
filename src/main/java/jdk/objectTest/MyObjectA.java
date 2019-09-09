package jdk.objectTest;

import org.junit.Test;


public class MyObjectA extends Object{


    public static void main(String[] args) {

    }

    /**
     * test clone()
     * @throws CloneNotSupportedException
     */
    @Test
    public void test01() throws CloneNotSupportedException {
        MyObjectA myObjectA = new MyObjectA();

        MyObjectA clone  = (MyObjectA) myObjectA.clone();

        System.out.println("myObjectA:"  + myObjectA.toString());
        System.out.println("myObjectAClone:"  + clone.toString());
    }

    /**
     * toString
     */
    @Test
    public void test02(){
        MyObjectA myObjectA = new MyObjectA();
        System.out.println("toString_"+ myObjectA.toString());
    }

    /**
     * hashCode
     */
    @Test
    public void test03(){
        MyObjectA myObjectA = new MyObjectA();
        System.out.println("hashCode_"+ myObjectA.hashCode());
    }

    /**
     * finalize
     */
    @Test
    public void test04() throws Throwable {
        MyObjectA myObjectA = new MyObjectA();
        myObjectA.finalize();
    }







}
