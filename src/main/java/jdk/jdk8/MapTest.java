package jdk.jdk8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {

    public static void main(String[] args) {

    }



    @Test
    public void test01(){

        Map<Integer, List<Integer>> map = new HashMap<>();

//        List<Integer> list = map.putIfAbsent(1, new ArrayList<>());


        map.computeIfAbsent(1, x -> new ArrayList<>()).add(1);

        map.computeIfAbsent(1, x -> new ArrayList<>()).add(2);

        map.computeIfAbsent(2, x-> new ArrayList<>()).add(3);


        Integer key = 1;
        List<Integer> valueList = new ArrayList<>();
        if(map.get(key) == null){
            List<Integer> integers = new ArrayList<>();
            integers.add(0);
            map.put(key, integers);
        }else{
            map.put(key, valueList);
        }

        map.computeIfAbsent(key, x -> new ArrayList<>()).add(key);


        System.out.println(map);

        List<Integer> ll = new ArrayList<>();
        ll.add(34);
        List<Integer> list1 = map.putIfAbsent(1,ll);

        System.out.println(list1.toString());


    }


    @Test
    public void test02(){

        Map<Integer, Integer> map = new HashMap<>();
        Integer i = map.put(1,2);
        System.out.println(i);
        Integer i1 = map.put(1,3);
        System.out.println(i1);

    }

    @Test
    public void test03(){
        List<Integer> list = new ArrayList<>();

        List<Integer> list1 = null;

        list.stream().forEach(x-> System.out.println(x));

        list1.stream().forEach(x-> System.out.println(x));
    }



    @Test
    public void test04(){


        Map<Integer, List<Long>> result = new HashMap<>();

        List<Long> longList = result.values().iterator().next();

        System.out.println(longList);




    }



    @Test
    public void test05(){


        Map<Integer, List<Integer>> map = new HashMap<>();

        map.computeIfAbsent(1, ArrayList::new).add(1);
        System.out.println(map.toString());

        map.computeIfAbsent(1, ArrayList::new).add(2);
        System.out.println(map.toString());

        map.computeIfAbsent(2, ArrayList::new).add(3);
        System.out.println(map.toString());



    }


    @Test
    public void test06(){

        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

        map.computeIfAbsent(1, HashMap::new).put(11,111);
        System.out.println(map.toString());

        map.computeIfAbsent(1, HashMap::new).put(22,111);
        System.out.println(map.toString());

        map.computeIfAbsent(2, HashMap::new).put(33,333);
        System.out.println(map.toString());


    }


    @Test
    public void test07(){

//        List<Employee> employees = new ArrayList<>();
        List<Employee> employees = null;

        Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.toList()));

        System.out.println(map);




    }








}
