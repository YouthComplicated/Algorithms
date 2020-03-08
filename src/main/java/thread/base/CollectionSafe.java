package thread.base;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: nj
 * @date: 2020-02-05 13:17
 * @version: 0.0.1
 */
public class CollectionSafe {

    /**
     *
     * 写时复制 copyOnWrite 容器即写时复制的容器 往容器添加元素的时候,不直接往当前容器object[]添加,而是先将当前容器object[]进行
     * copy 复制出一个新的object[] newElements 然后向新容器object[] newElements 里面添加元素 添加元素后,
     * 再将原容器的引用指向新的容器 setArray(newElements);
     * 这样的好处是可以对copyOnWrite容器进行并发的读,而不需要加锁 因为当前容器不会添加任何容器.所以copyOnwrite容器也是一种
     * 读写分离的思想,读和写不同的容器.
     *          public boolean add(E e) {
     *         final ReentrantLock lock = this.lock;
     *         lock.lock();
     *         try {
     *             Object[] elements = getArray();
     *             int len = elements.length;
     *             Object[] newElements = Arrays.copyOf(elements, len + 1);
     *             newElements[len] = e;
     *             setArray(newElements);
     *             return true;
     *         } finally {
     *             lock.unlock();
     *         }
     *     }
     */
    public static void main(String[] args) {
        /**
         * 1、并发场景下会有问题
         */
        List<String> list1= new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(list1);
            },String.valueOf(i)).start();
        }

        /**
         * 2、相应集合对应线程安全类
         */
        List<String> list2 = new Vector<>();

        /**
         * 3、
         */
        List<String> list3 = Collections.synchronizedList(new ArrayList<>());


        List<String> list= new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        /**
         * 1.故障现象
         *  java.util.ConcurrentModificationException
         * 2.导致原因
         *    并发争抢修改导致
         * 3.解决方案
         *  3.1 new Vector<>()
         *  3.2 Collections.synchronizedList(new ArrayList<>());
         *  3.3 new CopyOnWriteArrayList<>();
         *
         *
         * 4.优化建议
         */


        Map<String, Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("a");



    }
}