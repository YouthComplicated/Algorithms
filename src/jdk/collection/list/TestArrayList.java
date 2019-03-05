package jdk.collection.list;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * @author NJ
 * @date 2019/2/26 17:49
 */
public class TestArrayList {


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
     * List 转换数组 toArray() 使用
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
     * 测试toArray使用
     */
    @Test
    public void testToArr(){
//        List list1 = new ArrayList();
//        List list2 = new ArrayList<Integer>();
//        list1.add(1);
//        list1.add("bbb");
//        list1.add(5L);
//        System.out.println(list1);
//        System.out.println(list1.toArray());
//        //迭代器遍历数组
//        Iterator iterator = list1.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        //工具类的遍历
//        System.out.println(Arrays.toString(list1.toArray()));

        Collection con = new ArrayList();
        con.add(1);
        con.add(2);
        con.add(3);

        System.out.println(con.toArray());

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
            TestArrayList.this.test01();
        }
    }

    /**
     * arrayList 迭代器
     *
     * ListIterator 只能用于遍历list集合
     *
     */
    @Test
    public void test07(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        System.out.println(list);
        ListIterator<Integer> iterator = list.listIterator(5);
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

        /**
         * 删除元素
         */
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list1.add(i+1);
        }
        System.out.println(list1);
        ListIterator<Integer> iterator1 = list1.listIterator();

//        while(iterator1.hasNext()){
//            iterator1.next();
//            iterator1.remove();
//        }

        iterator1.next();
        iterator1.remove();
        System.out.println(iterator1.previousIndex());
        System.out.println("删除之后：" + list1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ListIterator<Integer> iterator2 = list2.listIterator();
        iterator2.add(999);
        iterator2.next();
        iterator2.add(8888);
        System.out.println("增加之后：" + list2);

    }

    /**
     * subList 进行截断处理
     * while(uulist.size() > 30){
     * List<Ctuuid> subList = uulist.subList(0, 30);
     * ctuuidMapper.batchInsert(subList);
     * subList.clear();
     * }
     */
    @Test
    public void test08(){

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(list);
        List<Integer> sub = list.subList(0,6);
        System.out.println("sub:"+sub);
        System.out.println("list:"+list);
        System.out.println("[sub == list]:"+(sub==list));
        System.out.println("[sub equals list]:"+(sub.equals(list)));
        sub.clear();
        System.out.println("清除sub之后:"+list);


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        //通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<>(list1);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());

        //修改list3
        list3.add(3);

        System.out.println("list1 == list2：" + list1.equals(list2));
        System.out.println("list1 == list3：" + list1.equals(list3));


        /**
         * subList生成子列表，尝试修改原列表异常:java.util.ConcurrentModificationException
         */
        List<Integer> list4 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4));
        List<Integer> list5 = list4.subList(0, list4.size());

        //read-only
        list4 = Collections.unmodifiableList(list4);
        list4.add(0);

        System.out.println(list4.size());
        System.out.println(list5.size());

    }

    /**
     * 并行迭代器研究 性能的分析，受约束的条件cpu等
     * spliterator
     */
    @Test
    public void test09(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        list.spliterator();
        System.out.println(list);

    }

    private AtomicInteger count = new AtomicInteger(0);
    private List<String> strList = createList();
    private Spliterator spliterator = strList.spliterator();

    /**
     * 多线程计算list中数值的和
     * 测试spliterator遍历
     */
    @Test
    public void mytest() {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("   " + threadName + " start ");
                spliterator.trySplit().forEachRemaining((o) -> {
                    if (isInteger((String) o)) {
                        int num = Integer.parseInt(o + "");
                        count.addAndGet(num);
                        System.out.println("数值：" + num + "     " + threadName);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                System.out.println("     " + threadName + " end");
            }).start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果为：" + count);
    }

    private List<String> createList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                result.add(i + "");
            } else {
                result.add("=");
            }
        }
        return result;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}


