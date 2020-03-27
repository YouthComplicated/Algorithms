package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-03-26 14:50
 * @version: 0.0.1
 */
public class Code_401 {

    /**
     *
     *  8, 4, 2, 1  hour
     *
     *  1 [1,2,4,8]
     *  2 [3,5,9,6,10,12]
     *  3 [7,]
     *
     *  32, 16, 8, 4, 2, 1  min
     *
     *
     *  A 数组 B 数组
     *
     *
     *  从AB 数组任意挑出若干字段进行相加
     *
     */

    static Map<Integer, List<String>> hourMap = new HashMap<>();
    static Map<Integer, List<String>> minMap = new HashMap<>();
    static {
        hourMap.put(0,new ArrayList<>(Arrays.asList("0")));
        hourMap.put(1,new ArrayList<>(Arrays.asList("1", "2", "4", "8")));
        hourMap.put(2,new ArrayList<>(Arrays.asList("3","5","9", "6","10","12")));
        hourMap.put(3,new ArrayList<>(Arrays.asList("7","11", "14")));
        hourMap.put(4,new ArrayList<>(Arrays.asList("15")));

        int[] minArr = {32,16,8,4,2,1};
        for (int i = 0; i < minArr.length; i++) {

        }
        minMap.put(0, new ArrayList<>(Arrays.asList("00")));
        minMap.put(1, new ArrayList<>(Arrays.asList("00")));
        minMap.put(2, new ArrayList<>(Arrays.asList("00")));
        minMap.put(3, new ArrayList<>(Arrays.asList("00")));
        minMap.put(4, new ArrayList<>(Arrays.asList("00")));
        minMap.put(5, new ArrayList<>(Arrays.asList("00")));
        minMap.put(5, new ArrayList<>(Arrays.asList("00")));
    }

    public List<String> readBinaryWatch(int num) {
        int[] hourArr = {8,4,2,1};
        int[] minArr = {32,16,8,4,2,1};
        List<String> result = new ArrayList<>();
        int k;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < hourArr.length;){

            }
            k = num - i;
            for(; ;){

            }

        }



        return null;
    }

    public List<String> readBinaryWatch1(int num) {
        int []hour = {1, 2, 4, 8, 16, 32, 1, 2, 4, 8};
        List<String> ans = new ArrayList<>();
        help(num, ans, 0, 0, hour, 0);
        return ans;
    }

    private void help(int num, List<String> ans, int h, int m, int []hour, int start){
        if(num == 0){
            StringBuilder temp = new StringBuilder();
            temp.append(h).append(':');
            if(m < 10){
                temp.append('0');
            }
            temp.append(m);
            ans.add(temp.toString());
            return;
        }
        for(int i = start; i < hour.length; i++){
            if(hour.length - i < num || num == 0){
                break;
            }
            int M = 0, H = 0;
            if(i < 6){
                M = hour[i];
            }else {
                H = hour[i];
            }
            if(H + h > 11){
                break;
            }
            if(M + m > 59){
                continue;
            }
            help(num - 1, ans, h + H, m + M, hour, i + 1);
        }
    }

    public static void main(String[] args) {

    }
}