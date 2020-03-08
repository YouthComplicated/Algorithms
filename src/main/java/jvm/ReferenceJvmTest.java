package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * java 强 软 弱 虚 引用的关系
 * @author: nj
 * @date: 2020-02-08 12:08
 * @version: 0.0.1
 */
public class ReferenceJvmTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 强引用
         */
        AA o1 = new AA("aaa");
        AA o2 = o1;

        o1 = null;
        System.gc();
        System.out.println("o1:"+o1);
        System.out.println("o2:"+o2.toString());

        /**
         * 软引用
         */
        Object object1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object1);
        System.out.println("object1:"+object1);
        System.out.println("softObj:"+softReference.get());
        object1 = null;
        System.gc();
        System.out.println("object1:"+object1);
        System.out.println("softObj:"+softReference.get());
        System.out.println("===============");
        /**
         * 虚引用
         */
        Object object2 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object2);
        System.out.println("object2:"+object2);
        System.out.println("softObj:"+weakReference.get());
        object2 = null;
        System.gc();
        System.out.println("object2:"+object2);
        System.out.println("softObj:"+weakReference.get());

        System.out.println("===============");
        /**
         * 为什么key 字符串常量池 与gc 关系
         */
//        Map map = new WeakHashMap<String, Integer>();
        WeakHashMap<String, Integer> map = new WeakHashMap<String, Integer>();
        String key = new String("aaa");
//        String key1 = "aa";
        map.put(key,2);
        System.out.println(map);
        key=null;
        System.out.println("key is invalid map: " + map+"map size"+map.size());
        System.gc();
        System.out.println("key is invalid gc : " + map+"map size"+map.size());

        /**
         * 虚引用
         */
        System.out.println("===============");
        Object object3 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object3, queue);
        System.out.println("obj3:"+phantomReference.get());
        System.out.println("queue-poll:"+queue.poll());

        object3 = null;
        System.out.println("obj3:"+phantomReference.get());
        System.out.println("queue-poll:"+queue.poll());
        System.gc();
        Thread.sleep(300);

        System.out.println("obj3:"+phantomReference.get());
        System.out.println("queue-poll:"+queue.poll());



    }



}

class AA{
    private String name = "aa";

    public AA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AA{" +
                "name='" + name + '\'' +
                '}';
    }
}