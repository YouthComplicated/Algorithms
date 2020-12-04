package jdk.collection.list;

import org.junit.Test;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

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

    private static final int DEFAULT_CAPACITY = 10;

    transient Object[] elementData;

    private int size;

    private int current = 0;


    public AbstractCollectionTest() {
    }

    public AbstractCollectionTest(Object[] elementData) {
        this.elementData = elementData;
        this.size = elementData.length;
    }

    @Override
    public Iterator<E> iterator() {
        /**
         * 匿名内部类实现接口
         */
        return new Iterator<E>() {
            /**
             * 方法中的匿名内部类访问外部类
             * @return
             */
            @Override
            public boolean hasNext() {
                return AbstractCollectionTest.this.current < size;
            }

            @Override
            public E next() {
                return (E)elementData[current++];
            }
        };
    }

    @Override
    public int size() {
        return this.size;
    }

//    @Override
//    public void forEach(Consumer<? super E> action) {
//        Objects.requireNonNull(action);
//        @SuppressWarnings("unchecked")
//        final E[] elementData = (E[]) this.elementData;
//        final int size = this.size;
//        for (int i=0;  i < size; i++) {
//            action.accept(elementData[i]);
//        }
//    }


    //    @Override
//    public boolean add(E e) {
//        size ++;
//        return super.add(e);
//    }

    public static void main(String[] args) {
        Integer [] a = {1,2,3};
        AbstractCollection<Integer> list = new AbstractCollectionTest<>(a);
        /**
         * 增强for循环  语法糖
         * Integer i;
         * for(Iterator iterator = list.iterator(); iterator.hasNext(); System.out.println(i)){
         *    i = (Integer)iterator.next();
         * }
         */
        for(Integer i : list){
            System.out.println(i);
        }

//        list.forEach(x-> System.out.println(x));


    }


    @Test
    public void test01(){
        AbstractCollectionTest<Integer> list = new AbstractCollectionTest<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        /**
         * 泛型不可以初始化??
         * 泛型数组的初始话
         */
//        E [] aa = new E[10];
    }





}
