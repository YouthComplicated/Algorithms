package jdk.exception;

import org.junit.Test;

import java.io.IOException;

public class TestException {


    public int test01(){


        int divider=10;
        int result=100;
        try{
            while(divider>-1){
                divider--;
                result=result+100/divider;
            }
            System.out.println("异常被catch捕获程序继续执行......");
            return result=888;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("异常抛出了！！");
            return result=999;
        }finally{
            System.out.println("这是finally，哈哈哈！！");
            System.out.println("result的值为："+result);
            //编译器警告
            return result=23456;
        }

        //return result;
    }


    public int test02(){

        int divider=10;
        int result=100;
        try{
//            while(divider>-1){
//                divider--;
//                result=result+100/divider;
//            }
            System.out.println("异常被catch捕获程序继续执行......");
            return result=888;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("异常抛出了！！");
            return result=999;
        }finally{
            System.out.println("这是finally，哈哈哈！！");
            //finally 在try中的return之后 在返回主调函数之前执行
            System.out.println("result的值为："+result);
            result = 7777;
            System.out.println("finally中改变result的值为："+result);
            //return result;//编译器警告
        }

        //return result;
    }

    public int test03(){


        int result=100;
        try{
            result = result/0;
            System.out.println("第一个异常被catch捕获程序继续执行......");
            String str = null;
            System.out.println(str.length());
            System.out.println("第二个异常被catch之后...");
            return result=888;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("异常抛出了！！");
//            return result=999;
        }
        finally{
            System.out.println("这是finally，哈哈哈！！");
            System.out.println("result的值为："+result);
            //return result;//编译器警告
        }

        return result;
    }


    public int test04 (int a, String str) throws NumberFormatException,IOException, Exception{
        return 12;
    }


    @SuppressWarnings("finally")
    public static int foo(){
        try{
            int a = 5 / 0;
        } catch (Exception e){
            return 1;
        } finally{
            return 2;
        }
    }

    @SuppressWarnings("finally")
    public static int bar() {
        try {
            return 1;
        }finally {
            return 2;
        }
    }

    public static void main(String[] args) {

        TestException instance = new TestException();
        System.out.println(instance.test01());

//        System.out.println("===========================");
//        System.out.println(instance.test02());
//        System.out.println("===========================");
//        System.out.println(instance.test03());


        int result;

        result = foo();
        System.out.println(result);

        result = bar();
        System.out.println(result);



    }



}
