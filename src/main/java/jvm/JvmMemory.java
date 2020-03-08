package jvm;

/**
 * @author: nj
 * @date: 2020-02-08 11:03
 * @version: 0.0.1
 */
public class JvmMemory {


    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("totalMemory:"+totalMemory+"字节,"+totalMemory/(double)(1024*1024)+"MB");
        System.out.println("maxMemory:"+maxMemory+"字节,"+maxMemory/(double)(1024*1024)+"MB");
        System.out.println("maxMemory:"+maxMemory+"字节,"+maxMemory/(double)(1024*1024*1024)+"GB");


        byte[] bytes = new byte[10*1024*1024];
    }
}