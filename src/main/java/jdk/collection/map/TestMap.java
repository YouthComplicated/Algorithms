package jdk.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NJ
 * @date 2019/3/5 11:39
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("a",1);
        System.out.println(map);

        System.out.println("1:" + 1/0.75+1);  //2 == 2
        System.out.println("2:" +  2/0.75+1); //3 == 4
        System.out.println("3:" +  3/0.75+1);//5 ==
        System.out.println("4:"+ 4/0.75+1);//6
        System.out.println("5:"+5/0.75+1);//7
        System.out.println("6:"+6/0.75+1);//9
    }

    /**
     * 初始化hashMap 容量规则
     */
    @Test
    public void testMap(){
        Map<String, Object> map = new HashMap<>(1);
        map.put("a",1);
//        map.put("b",2);
//        map.put("c",3);

        System.out.println(map);
        System.out.println(map.getOrDefault("a", 45));


//        System.out.println("1:" + tableSizeFor(1));
//        System.out.println("2:" + tableSizeFor(2));
//        System.out.println("3:" + tableSizeFor(3));
//        System.out.println("4:"+ tableSizeFor(4));
//        System.out.println("5:"+tableSizeFor(5));



        System.out.println("2:" + tableSizeFor(2));
        System.out.println("3:" + tableSizeFor(3));
        System.out.println("5:" + tableSizeFor(5));
        System.out.println("6:"+ tableSizeFor(6));
        System.out.println("7:"+tableSizeFor(7));



    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1111) ? (1111) : n + 1;
    }

    /**
     * 红黑树黑化过程
     */
    @Test
    public void testMap1(){
        Map<String, Object> map  = new HashMap<>();
        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);

//        System.out.println(map.keySet());
//        System.out.println(map.values());


        //map内的数组容量大于等于64 且 链表数量大于8才会进行红黑树转换
        HashMap map1 = new HashMap(64);
        for (int i = 0; i <= 8; i++) {
            map1.put(new HashCodeOneObj(i), i);
        }
        System.out.println(map1);

    }

    private static class HashCodeOneObj implements Comparable<HashCodeOneObj> {
        private int val;

        public HashCodeOneObj(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int hashCode() {
            return 1; //让所有数据都存入一个桶
        }

        @Override
        public int compareTo(HashCodeOneObj o) {
            if (null == o) {
                return -1;
            }
            return Integer.compare(this.getVal(), o.getVal());
        }
    }

    /**
     * String类型hashCode冲突
     */
    @Test
    public void testMap2(){
        String str1 = "!~";
        String str2 = "\"_";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }




}
