import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {

        String obj = null;

        System.out.println(String.valueOf(obj));


        System.out.println("----------------------------");

        Map<String, Object> map  = new HashMap<>();

        Long l = (Long)map.get("ttt");
        System.out.println(l);


//
//        Map<String, Object> map1  = null;
//
//        Long tt = (Long)map1.get("ttt");
//        System.out.println(tt);


        System.out.println("Hello World!");

        List<Long> abnormalList = new ArrayList<>();
        abnormalList.add(3L);
        abnormalList.add(4L);
        abnormalList.add(1L);
        abnormalList.add(9L);

        List<Long> otherAlarmTimes = new ArrayList<>();
        otherAlarmTimes.add(3L);
        otherAlarmTimes.add(15L);

        /**
         * 并集
          */
//        otherAlarmTimes.removeAll(abnormalList);
//        abnormalList.addAll(otherAlarmTimes);


        /**
         * 交集
         */
        otherAlarmTimes = null;
        abnormalList.retainAll(otherAlarmTimes);
        Collections.sort(abnormalList);
        System.out.println(abnormalList);
    }


    @Test
    public  void test01(){
        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);
        Map<String, Object> temp = map;
        for(Map.Entry<String, Object> entry : temp.entrySet()){
            if(entry.getKey().equals("bb")){
                map.remove(entry.getKey());
            }
        }

//        temp.remove("bb");
        System.out.println("map:"+map.toString());
        System.out.println("temp："+temp.toString());


        Map<String, Object> map1 = new HashMap<>();
        map1.put("aa",1);
        map1.put("bb",2);
        map1.put("cc",3);

        Map<String, Object> temp1 = map1;

        for(Map.Entry<String, Object> entry : temp1.entrySet()){
            if(entry.getKey().equals("bb")){
                map1.remove(entry.getKey());
            }
        }

        temp1.remove("bb");
        System.out.println("map1:"+map1.toString());
        System.out.println("temp1："+temp1.toString());


    }


    @Test
    public void test02(){
        map.put("aa",1);
        map.put("bb",2);
        Map<String, Map<String, Object>> map = new HashMap<>();
    }


    @Test
    public void test03(){
        Map<String, Object> map = new HashMap<>();
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:"+ entry.getKey()+"value:"+ entry.getValue());
        }
        System.out.println(1111);




    }


}
