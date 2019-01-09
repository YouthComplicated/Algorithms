import java.util.*;

public class Main {

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
}
