package jdk.collection.list;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * List 实现
 * @param <E>
 */
public class MyAbstractCollection<E> extends AbstractCollection<E> implements Serializable, RandomAccess, Cloneable {

    /**
     * 集合长度
     */
    private int size;

    /**
     * 存储的数据数组
     */
    Object[] elementData;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 按照执行size初始化
     * @param size
     */
    public MyAbstractCollection(int size) {
//        this.size = size;
        this.elementData = new Object[size];
    }

    public MyAbstractCollection(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyAbstractCollection(Collection<? extends E> c){

    }

    protected transient int modCount = 0;

    /**
     * 内部类封装迭代器，只对内部使用
     */
    private class Itr implements Iterator<E> {
        // index of next element to return
        int cursor;
        // index of last element returned; -1 if no such
        int lastRet = -1;
        int expectedModCount = modCount;

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size){
                throw new NoSuchElementException();
            }
            Object[] elementData = MyAbstractCollection.this.elementData;
            if (i >= elementData.length){
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0){
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                MyAbstractCollection.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = MyAbstractCollection.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = MyAbstractCollection.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
        }
    }



    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        this.elementData[size++] = e;
        return true;
    }

    public static void main(String[] args) {
        MyAbstractCollection<Integer> collection = new MyAbstractCollection<>(10);
        collection.add(1);
        collection.add(2);
        System.out.println(collection.toString());
     }

     @Test
     public void test01(){
         MyAbstractCollection<Integer> collection = new MyAbstractCollection<>(10);
         collection.add(1);
         collection.add(2);
         System.out.println(collection.toString());
     }

}
