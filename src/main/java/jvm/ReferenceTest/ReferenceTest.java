package jvm.ReferenceTest;


import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 强引用、弱引用、软引用、虚引用
 */
public class ReferenceTest {


    public static void main(String[] args) {
        //强引用
        String str = new String("abc");
        //弱引用
        SoftReference<String> softReference = new SoftReference<>(str);
    }


    private static ReferenceQueue<byte[]> rq = new ReferenceQueue<>();
    private static int _1M = 1024*1024;


    @Test
    public void test01(){
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while((k = (WeakReference) rq.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch(InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        for(int i = 0;i < 10000;i++) {
            byte[] bytes = new byte[_1M];
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, rq);
            map.put(weakReference, value);
        }
        System.out.println("map.size->" + map.size());
    }


}
