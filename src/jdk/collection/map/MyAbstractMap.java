package jdk.collection.map;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @author NJ
 * @date 2019/3/5 17:36
 */
public class MyAbstractMap<K,V> extends AbstractMap<K,V> implements Map<K,V> {

    /**
     * 两个成员变量：
     * keySet, 保存 map 中所有键的 Set
     * values, 保存 map 中所有值的集合
     * 他们都是 transient, volatile, 分别表示不可序列化、并发环境下变量的修改能够保证线程可见性。
     * 需要注意的是 volatile 只能保证可见性，不能保证原子性，需要保证操作是原子性操作，才能保证使用 volatile 关键字的程序在并发时能够正确执行。
     * @return
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new MyAbstractMap<>();

        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);
        System.out.println(map);
    }

}
