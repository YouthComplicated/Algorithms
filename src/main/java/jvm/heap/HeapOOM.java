package jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-07-29 19:48
 * @version: 0.0.1
 */
public class HeapOOM {

    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {

        List<HeapOOM> all = new ArrayList<>();

        while (true){
            all.add(new HeapOOM());
            Thread.sleep(10);
        }


    }


}