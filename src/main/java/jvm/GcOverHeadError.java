package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-02-08 15:04
 * @version: 0.0.1
 */
public class GcOverHeadError {

    public static void main(String[] args) {

        /**
         * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
         *
         * java.lang.OutOfMemoryError: GC overhead limit exceeded
         *
         *
         */
        List<String> list = new ArrayList<>();
        int i = 0;

        try{
            while (true){
                list.add(String.valueOf(i++).intern());
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {

        }
    }
}