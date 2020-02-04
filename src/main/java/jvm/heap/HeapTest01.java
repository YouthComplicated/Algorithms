package jvm.heap;

import java.util.Random;

public class HeapTest01 {
    public static void main(String[] args) {
        String str = "www.atguigu.com" ;
        while(true) {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
        }

    }
}
