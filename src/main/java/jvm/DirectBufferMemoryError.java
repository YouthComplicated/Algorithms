package jvm;


import java.nio.ByteBuffer;

/**
 * @author: nj
 * @date: 2020-02-08 15:25
 * @version: 0.0.1
 */
public class DirectBufferMemoryError {


    public static void main(String[] args) {

        /**
         * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
         */
        System.out.println("MaxDirectBufferMemory:"+sun.misc.VM.maxDirectMemory()/(double)(1024*1024)+"MB");

        try{
            Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            
        }

        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);
    }
}