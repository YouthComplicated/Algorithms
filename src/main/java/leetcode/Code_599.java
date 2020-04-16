package leetcode;

import base.Arrays.Array;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-15 20:18
 * @version: 0.0.1
 */
public class Code_599 {

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
     * represented by strings.
     *
     * You need to help them find out their common interest with the least list index sum. If there is a choice tie between
     * answers, output all of them with no order requirement. You could assume there always exists an answer.
     *
     * Example 1:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * Output: ["Shogun"]
     * Explanation: The only restaurant they both like is "Shogun".
     * Example 2:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * Output: ["Shogun"]
     * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
     * Note:
     * The length of both lists will be in the range of [1, 1000].
     * The length of strings in both lists will be in the range of [1, 30].
     * The index is starting from 0 to the list length minus 1.
     * No duplicates in both lists.
     *
     *
     *
     * 使用map list1, 不会重复
     */

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        int i = 0, min = Integer.MAX_VALUE;
        for(String str : list1){
            map.put(str, i++);
        }
        int j = 0, index;
        for(String str : list2){
            if(map.containsKey(str)){
                index = map.get(str) + j;
                min = Math.min(min, index);
                map1.put(str, index);
            }
            j++;
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(entry.getValue() == min){
               list.add(entry.getKey());
            }
        }
        String [] result = new String[list.size()];
        int l = 0;
        for(String str : list){
            result[l++] = str;
        }
        return result;


    }

    public static String[] findRestaurant11(String[] list1, String[] list2) {
        return null;
    }


    public static void main(String[] args) {

        String[] list1 ={"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1,list2)));





    }







}