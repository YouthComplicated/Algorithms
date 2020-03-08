package jvm;

/**
 *
 * jvm常见异常
 *
 * @author: nj
 * @date: 2020-02-08 14:48
 * @version: 0.0.1
 */
public class JvmError {


    public static void statckOverFlow(){
        statckOverFlow();
    }

    public static void main(String[] args) {
        /**
         * at jvm.JvmException.statckOverFlow(JvmException.java:15)
         *
         * 栈溢出- 512k~1024k
         */
        statckOverFlow();

    }


}