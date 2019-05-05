package jdk.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

/**
  * @Description: 流使用
  * @Author: NJ
  * @CreateDate:2019-05-04 15:58
  * @Version:1.0
*/
public class StreamTest {

    @Test
    public void test01(){

        //可变形参 -> stream
        Stream stream1 = Stream.of("hello", "world", "hello world");

        //array -> stream
        String[] myArray = new String[]{"hello", "world", "hello world"};

        Stream stream2 = Stream.of(myArray);

        //工具类的方式提供
        Stream stream3 = Arrays.stream(myArray);

        //list -> stream
        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();

    }

    @Test
    public void test02(){

        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);
        System.out.println("-------");

        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("-------");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }


    /**
     * 累加操作 reduce[终止操作]  map reduce
     */
    @Test
    public void test03(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));

    }

    /**
     * java.lang.IllegalStateException: stream has already been operated upon or closed
     *
     * 一个流只能使用一次
     *
     * Stream 转换为数组,集合等
     */
    @Test
    public void test04(){

        /**
         * Stream<String> -> String[]
         */
        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        String[] stringArray1 = stream.toArray(length -> new String[length]);

        Stream<String> stream1 = Stream.of("hello", "world", "helloworld");
        String[] stringArray = stream1.toArray(String[]::new);

        Arrays.asList(stringArray).forEach(System.out::println);

        /**
         * Stream -> List
         */
        Stream<String> stream2 = Stream.of("hello", "world", "helloworld");
        List<String> list1 = stream2.collect(Collectors.toList());

        /**
         *     <R> R collect(Supplier<R> supplier,
         *                   BiConsumer<R, ? super T> accumulator,
         *                   BiConsumer<R, R> combiner);
         *
         * @param supplier a function that creates a new result container. For a
         *                 parallel execution, this function may be called
         *                 multiple times and must return a fresh value each time.
         * @param accumulator an function for incorporating an additional element into a result
         * @param combiner an function for combining two values, which must be
         *                    compatible with the accumulator function
         *
         *
         * <pre>{@code
         *     String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,
         *                                          StringBuilder::append)
         *                                 .toString();
         * }</pre>
         */
        Stream<String> stream3 = Stream.of("hello", "world", "helloworld");
        List<String> list2 = stream3.collect(() -> new ArrayList(), (theList, item) -> theList.add(item),
                (theList1, theList2) -> theList1.addAll(theList2));

        Stream<String> stream4 = Stream.of("hello", "world", "helloworld");
        List<String> list = stream4.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list.forEach(System.out::println);


        Stream<String> stream5 = Stream.of("hello", "world", "helloworld");
        List<String> list3 = stream5.collect(Collectors.toCollection(ArrayList::new));
        list3.forEach(System.out::println);


        Stream<String> stream6 = Stream.of("hello", "world", "helloworld");
        Collection<String> col  = stream6.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collection:=====");
        col.forEach(System.out::println);


        Stream<String> stream7 = Stream.of("hello", "world", "helloworld");
        Set<String> set = stream7.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set.getClass());
        set.forEach(System.out::println);

        Stream<String> stream8 = Stream.of("hello", "world", "helloworld");
        String str = stream8.collect(Collectors.joining());
        System.out.println(str);

    }

    /**
     * 字符串变大写  元素的映射 map
     */
    @Test
    public void test05(){

        List<String> list = Arrays.asList("aa","bb","cvbwe","123");
        List<String> upCaseList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        upCaseList.forEach(System.out::println);


        List<Integer> integerList = Arrays.asList(1,2,3,4);
        integerList.stream().map(value -> value * value).collect(Collectors.toList()).forEach(System.out::println);

        /**
         * Returns a stream consisting of the results of replacing each element of
         * this stream with the contents of a mapped stream produced by applying
         * the provided mapping function to each element.  Each mapped stream is
         * {@link java.util.stream.BaseStream#close() closed} after its contents
         * have been placed into this stream.  (If a mapped stream is {@code null}
         * an empty stream is used, instead.)
         *
         * <p>This is an <a href="package-summary.html#StreamOps">intermediate
         * operation</a>.
         *
         * @apiNote
         * The {@code flatMap()} operation has the effect of applying a one-to-many
         * transformation to the elements of the stream, and then flattening the
         * resulting elements into a new stream.
         *
         * <p><b>Examples.</b>
         *
         * <p>If {@code orders} is a stream of purchase orders, and each purchase
         * order contains a collection of line items, then the following produces a
         * stream containing all the line items in all the orders:
         * <pre>{@code
         *     orders.flatMap(order -> order.getLineItems().stream())...
         * }</pre>
         *
         * <p>If {@code path} is the path to a file, then the following produces a
         * stream of the {@code words} contained in that file:
         * <pre>{@code
         *     Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
         *     Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
         * }</pre>
         * The {@code mapper} function passed to {@code flatMap} splits a line,
         * using a simple regular expression, into an array of words, and then
         * creates a stream of words from that array.
         *
         * @param <R> The element type of the new stream
         * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
         *               <a href="package-summary.html#Statelessness">stateless</a>
         *               function to apply to each element which produces a stream
         *               of new values
         * @return the new stream
         *
         * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
         */


        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),
                Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        Stream<Integer> integerStream = stream.flatMap(theList -> theList.stream()).map(item -> item * item);
        integerStream.forEach(System.out::println);


    }

    /**
     * generate uuid get firstOne
     *
     * 生成加密字符串,token 涉及到uuid的场景
     */
    @Test
    public void test06(){

        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        //错误写法
//        System.out.println(stream.findFirst().get());
        stream.findFirst().ifPresent(System.out::println);


        System.out.println("==============");
        /**
         * iterate 无限流 必须限制产生多少个
         */
        Stream<Integer> stream1 = Stream.iterate(1, item -> item + 2).limit(6);
        stream1.forEach(System.out::println);

    }

    /**
     *
     * 找出流中大于2的元素，然后每个元素乘以2，忽略流中的前两个元素，然后再求和
     *
     * filter  map mapToInt[避免拆装箱] skip limit sum min
     */
    @Test
    public void test07(){

        //使用流生成随机字符串
//        Stream<Integer> stream1 = Stream.iterate(1, item -> Random::nextInt(3)).limit(6);


        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream.filter(item -> item > 200).mapToInt(item -> item * 2).skip(2).limit(2).sum());

        stream.filter(item -> item > 200).mapToInt(item -> item * 2).max().ifPresent(System.out::println);



    }


    @Test
    public void test08(){

        /**
         * 求和相关 IntSummaryStatistics
         */
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);

        IntSummaryStatistics summaryStatistics = stream.filter(item -> item > 2).
        mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();

        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());


        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).distinct());


    }


    @Test
    public void test09(){
        List<String> list = Arrays.asList("hello", "world", "hello world");

        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).
                forEach(System.out::println);


        List<String> list1 = Arrays.asList("hello", "world", "hello world");
        //map 不会打印test 原因:惰性求值
        list1.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });

        List<String> list2 = Arrays.asList("hello", "world", "hello world");
        list2.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("testxxxxxxx");
            return result;
        }).forEach(System.out::println);

    }

    /**
     * @see IntStream
     * @see LongStream
     * @see DoubleStream
     */
    @Test
    public void test010(){
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }

    /**
     * 并行流和串行流
     */
    @Test
    public void test011(){
        List<String> list = new ArrayList<>(5000000);

        for(int i = 0; i < 5000000; ++i) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("parallel开始排序-");
        long startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("parallel排序耗时：" + millis);

        System.out.println("sequential开始排序-");
        long startTime1 = System.nanoTime();
        list.stream().sorted().count();
        long endTime1 = System.nanoTime();
        long millis1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
        System.out.println("sequential排序耗时：" + millis1);

    }

    /**
     * 流存在短路运算
     */
    @Test
    public void test012(){

        List<String> list = Arrays.asList("hello", "world1", "hello world");

//        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).
//                findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }

    @Test
    public void test013(){

        List<String> list = Arrays.asList("hello welcome", "world hello",
                "hello world hello", "hello welcome");

//        List<String[]> result = list.stream().map(item -> item.split(" ")).distinct().
//                collect(Collectors.toList());
//        result.forEach(item -> Arrays.asList(item).forEach(System.out::println));

        List<String> result = list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().
                collect(Collectors.toList());

        result.forEach(System.out::println);
    }


    @Test
    public void test014(){

        /**
         * 实现 两层for循环
         */
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        List<String> result = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).
                collect(Collectors.toList());
        result.forEach(System.out::println);

    }

    /**
     * 分组demo  现实中以map接收实体居多，如何解决这个问题？？？？
     *
     * 分组：group by
     * 分区：partitioningBy
     */
    @Test
    public void test15(){


        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

//        Map<String, List<Student>> map = students.stream().
//                collect(Collectors.groupingBy(Student::getName));

//        Map<Integer, List<Student>> map = students.stream().
//                collect(Collectors.groupingBy(Student::getScore));

//        Map<String, Long> map = students.stream().
//                collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        Map<String, Double> map = students.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        /**
         * 分区函数
         */
        Map<Boolean, List<Student>> map1 = students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

        System.out.println(map);

        System.out.println(map1);
    }


}
