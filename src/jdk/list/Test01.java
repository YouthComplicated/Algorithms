package jdk.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author NJ
 * @date 2019/2/26 17:49
 */
public class Test01 {


    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(2);
        List<Integer> list3 = new ArrayList<>(list1);

        System.out.println();
        for(int i = 0; i < 5; i++){
            list2.add(i);
        }
        System.out.println(list2.toString());

    }

    @Test
    public void test01(){

        System.out.println(Object[].class);
        System.out.println(Integer.class);

//        DEFAULTCAPACITY_EMPTY_ELEMENTDATA[0] = 0;
//        System.out.println(DEFAULTCAPACITY_EMPTY_ELEMENTDATA);

    }

    /**
     * 数组扩容机制
     */
    @Test
    public void test02(){

        /**
         * 泛型初始化，子类方法调用不到原因???
         */
        List<Integer> list1  = new ArrayList<>();
//        list1.ensureCapacity();
        for(int i = 0; i < 20; i++){
            list1.add(1);
            System.out.println(list1.size());
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.ensureCapacity(5);
        for(int i = 0; i < 20; i++){
            list2.add(1);
            System.out.println(list2.size());
        }

        Integer[] ll = new Integer[]{1,2,3};
        System.out.println(ll);

    }

    /**
     * 进制转化问题 位运算
     */
    @Test
    public void test03(){
        /**
         * 1,2,3,4,5,6,7,8,9,a,b,c,d,e,f
         */
        System.out.println(0x7fffffff);

        System.out.println(0x7f);

        System.out.println(0xf);
    }

    /**
     * List 转换数组
     */
    @Test
    public void test04(){
        List<Integer> list1  = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list1.add(i);
        }

        System.out.println(list1);

//        Integer[] array = (Integer[]) list1.toArray();
//        array[1] = 10;

//        ArrayList<Integer> list2  = new ArrayList<>();
//        Integer[] array2 = (Integer[]) list2.toArray();

        Integer[] array1 = {1,2,3};
        Integer [] arrays = list1.toArray(array1);
        System.out.println(Arrays.toString(arrays));

        /**
         * 正确的写法
         */
        Integer [] arrays1 = list1.toArray(new Integer[40]);
        System.out.println(Arrays.toString(arrays1));

//        List<Object> objects = new ArrayList<>();
//        objects.add(1);
//        objects.add("2");
//        System.out.println(objects);
//
//        List<Integer> integers = (List<Integer>) objects;
    }

    /**
     * addAll()
     */
    @Test
    public void test05(){
        System.out.println(111);
//        List<Integer> list1 = Arrays.asList(1,3,4);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(5,6,7,9);
        List<Integer> list3 = Arrays.asList(555,3333,7777,000);
        list1.addAll(list2);
        list1.addAll(list3);
        System.out.println(list1);
    }

    /**
     * removeRange
     */
    @Test
    public void test06(){
        ArrayList<Integer> objs = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};

        List<Integer> list = new ArrayList<>();


        MyList<Integer> myobjs = new MyList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(9);
            add(5);
        }};

//        myobjs.removeRange(1,3);

//        myobjs.removeRange(-1,-2);

        System.out.println(myobjs);
        myobjs.removeRange(3,1);
        System.out.println(myobjs);


    }

    class MyList<E> extends ArrayList<E>{
        @Override
        protected void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }

        /**
         * 内部类调用主类方法
         */
        public  void transfer(){
            Test01.this.test01();
        }
    }

    /**
     * arrayList 迭代器
     */
    @Test
    public void test07(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        System.out.println(list);
        ListIterator<Integer> iterator =  list.listIterator();

        while (iterator.hasPrevious()){
            System.out.println(iterator.next());
        }

    }



}


