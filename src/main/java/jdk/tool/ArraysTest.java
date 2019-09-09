package jdk.tool;

import base.Arrays.Array;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;

public class ArraysTest {


    /**
     *
     *  DualPivotQuicksort:双轴快速排序
     *
     */
    @Test
    public void test01(){
        int [] arr = {1,2,3,4,5,6,1,2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        int [] arr1 = {8,7,6,5,4,3,2,1};
        Arrays.sort(arr1,3,5);
        System.out.println(Arrays.toString(arr1));



        int [] arr2 = {8,7,6,5,4,3,2,1};
        Arrays.parallelSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }


    @Test
    public void test02(){
        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(1<<3);
    }

    /**
     *
     * 1、包装类加减乘除不用显示unbox
     *
     *
     */
    @Test
    public void test03(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        Comparator<Integer> comparator1 = (x,y) ->{
            return x - y;
        };

        Comparator<Integer> comparator2 = (x,y) ->{
            return x.compareTo(y);
        };

        Comparator<Integer> comparator3 = (x,y) -> y.compareTo(x);

        /**
         * 正序
         */
        Comparator<Integer> comparator4 = Comparator.naturalOrder();
        /**
         * 倒序
         */
        Comparator<Integer> comparator5 = Comparator.reverseOrder();


        int [] arr = {5,4,3,2,1};

        Integer[] arr1 = {5,4,3,2,1};
        Arrays.sort(arr1,comparator5);
        Arrays.sort(arr1,comparator4);
        System.out.println(Arrays.toString(arr1));

    }


    /**
     *
     * Arrays.parallelPrefix 效率
     *
     */
    @Test
    public void test04(){

        Integer [] arr = {0,1,2,3,4,5,6};

        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        BinaryOperator<Integer> binaryOperator1 = (x, y) -> x+y;
        Arrays.parallelPrefix(arr, binaryOperator1);
        System.out.println(Arrays.toString(arr));

        BinaryOperator<Integer> binaryOperator2 = (x, y) -> x - y;
        Arrays.parallelPrefix(arr, binaryOperator2);
        System.out.println(Arrays.toString(arr));

        /**
         * 正序
         */
        Integer [] arr1 = {0,1,2,3,4,5,6};
        Comparator<Integer> comparator = Comparator.naturalOrder();
//        System.out.println(BinaryOperator.maxBy(comparator));
        Arrays.parallelPrefix(arr1, BinaryOperator.maxBy(comparator));
        System.out.println("maxBy:"+ Arrays.toString(arr1));

        Integer [] arr2 = {0,9,8,6,100,88,99};
        Arrays.parallelPrefix(arr2, BinaryOperator.minBy(comparator));
        System.out.println("minxBy:"+Arrays.toString(arr2));


    }

    /**
     *
     * binarySearch
     *
     * 1、先排序
     *
     * 2、重复不保证哪一个被找到
     *
     * 场景：
     */
    @Test
    public void test05(){

        int [] arr = {5,4,3,2,1};
        System.out.println("BinarySearch(unsort):"+ Arrays.binarySearch(arr,  5));

        int [] arr1 = {1,2,3,4,5};
        System.out.println("BinarySearch:"+ Arrays.binarySearch(arr1,  5));

        int [] arr2 = {1,2,3,3,4,5};
        System.out.println("BinarySearch:"+ Arrays.binarySearch(arr2,  3));

        int [] arr3 = {1,2,3,3,3,4,5};
        System.out.println("BinarySearch:"+ Arrays.binarySearch(arr3,  3));

    }


    /**
     *
     *  why double 和float 比较不用!=   ????
     *
     */
    @Test
    public void test06(){

        int [] arr = {5,4,3,2,1};
        int [] arr1 = {3,4,3,2,1};
        System.out.println("equals:" + Arrays.equals(arr,arr1));

//        int [] arr = {5,4,3,2,1};
//        int [] arr1 = {3,4,3,2,1};
//        System.out.println("equals:" + Arrays.equals(arr,arr1));

        /**
         *  public static boolean equals(double[] a, double[] a2) {
         *             if (a==a2)
         *                 return true;
         *             if (a==null || a2==null)
         *                 return false;
         *
         *             int length = a.length;
         *             if (a2.length != length)
         *                 return false;
         *
         *             for (int i=0; i<length; i++)
         *                 if (Double.doubleToLongBits(a[i])!=Double.doubleToLongBits(a2[i]))
         *                     return false;
         *
         *             return true;
         *         }
         *
         *
         *     public static boolean equals(float[] a, float[] a2) {
         *         if (a==a2)
         *             return true;
         *         if (a==null || a2==null)
         *             return false;
         *
         *         int length = a.length;
         *         if (a2.length != length)
         *             return false;
         *
         *         for (int i=0; i<length; i++)
         *             if (Float.floatToIntBits(a[i])!=Float.floatToIntBits(a2[i]))
         *                 return false;
         *
         *         return true;
         *     }
         */

    }

    /**
     * fill 填充数组的值
     */
    @Test
    public void test07(){

        int [] arr = {5,4,3,2,1};
        Arrays.fill(arr, 0);
        System.out.println(Arrays.toString(arr));

        int [] arr1 = new int[3];
        System.out.println(Arrays.toString(arr1));
        Arrays.fill(arr1, 3);
        System.out.println(Arrays.toString(arr1));

        boolean [] flag = new boolean[5];
        System.out.println(Arrays.toString(flag));
        Arrays.fill(flag, true);
        System.out.println(Arrays.toString(flag));

    }

    /**
     *
     * copyOf
     *
     * copyOfRange from to
     *
     *
     * 调用System.copyOf()   native
     *
     */
    @Test
    public void test08(){

        int [] arr1 = {1,2,3};
        int [] arr2 = Arrays.copyOf(arr1, 2);
        System.out.println("arr1:"+Arrays.toString(arr1));
        System.out.println("arr2:"+Arrays.toString(arr2));

        Student student1 = new Student(12,"张三");
        Student student2 = new Student(25,"李四");
        Student student3 = new Student(30,"万里无");

        Student [] students = new Student[4];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        System.out.println(Arrays.toString(students));

        Object[] result = Arrays.copyOf(students,2,Object[].class);
        System.out.println("=============");
        System.out.println(Arrays.toString(result));

        Student[] result1 = Arrays.copyOf(students,10,Student[].class);
        System.out.println("=============");
        System.out.println(Arrays.toString(result1));

//        Teacher[] result2 = Arrays.copyOf(students,10,Teacher[].class);
//        System.out.println("=============");
//        System.out.println(Arrays.toString(result2));


    }

    /**
     *
     * setAll()  intFunction 接收一个数组下标
     *
     * public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
     *         Objects.requireNonNull(generator);
     *         for (int i = 0; i < array.length; i++)
     *             array[i] = generator.apply(i);
     * }
     *
     */
    @Test
    public void test09(){

        Integer [] arr1 = {1,2,3};
        System.out.println("arr1:"+Arrays.toString(arr1));

//        Spliterator spliterator = Arrays.spliterator(arr1);
//        System.out.println(spliterator);

        IntFunction<Integer> function = new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                return arr1[value] + 2;
            }
        };

        Arrays.setAll(arr1, function);
        System.out.println("setAll_arr1:" + Arrays.toString(arr1));

        IntFunction<Integer> function1 = x -> x+2;
        Arrays.setAll(arr1, function1);
        System.out.println("setAll1_arr1:" + Arrays.toString(arr1));

        IntFunction<Integer> function2 = x -> x*2;
        Arrays.setAll(arr1, function2);
        System.out.println("setAll2_arr1:" + Arrays.toString(arr1));

//        Integer [] arr2 = {1,2,3};
//        Arrays.stream(arr2).map(function2).forEach(System.out::println);

        Integer[] arr2 = new Integer[3];
        Arrays.setAll(arr2, function);
        System.out.println("setAll3_arr1:" + Arrays.toString(arr2));
    }



    @Test
    public void test10(){

        IntFunction<String> f1 = Integer::toString;
        /**
         *
         * 无法指定方法  Integer
         *
         * public static String toString(int i);
         *
         * public String toString();
         *
         * 在IntFunction< String>的情况下,只有公共静态String toString(int i)适用.
         *
         *
         */
//        Function<Integer, String> f2 = Integer::toString;
        Function<Integer, String> f3 = i -> Integer.toString (i);


    }

}

class Student implements Serializable {
    private static final long serialVersionUID = -5105137441035558607L;
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Teacher {
    private int age;
    private String name;


    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
