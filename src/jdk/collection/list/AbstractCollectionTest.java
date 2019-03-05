package jdk.collection.list;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 *
 * 对于一个不可更改的集合，只要继承这个类并且实现迭代器和size()方法就行。
 * 对于一个可更改的集合，需要重写add()和返回Iterator的方法，当然可选的实现remove方法
 *
 * 自定义相应的存储元素的数组
 *
 * @param <E>
 */
public class AbstractCollectionTest<E>  extends AbstractCollection<E> {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    public static void main(String[] args) {
        AbstractCollection<Integer> list = new AbstractCollectionTest<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        Object[] objects = list.toArray();
        System.out.println(objects.toString());
    }





}
