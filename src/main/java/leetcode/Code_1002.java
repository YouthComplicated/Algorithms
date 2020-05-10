package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-05-09 11:15
 * @version: 0.0.1
 */
public class Code_1002 {


    /**
     * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in
     * all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings
     * but not 4 times, you need to include that character three times in the final answer.
     *
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: ["bella","label","roller"]
     * Output: ["e","l","l"]
     * Example 2:
     *
     * Input: ["cool","lock","cook"]
     * Output: ["c","o"]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 100
     * A[i][j] is a lowercase letter
     *
     *
     */

    public static List<String> commonChars(String[] A) {

        List<String> result = new ArrayList<>();
        if(A == null || A.length < 2){
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : A[0].toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for(Character c : A[i].toCharArray()){
                tempMap.put(c, tempMap.getOrDefault(c,0) + 1);
            }
            if(map.isEmpty()){
                return result;
            }
//            map.entrySet().removeIf(entry -> tempMap.containsKey(entry.getKey()));



            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Character, Integer> entry;
            Character key;
            while (iterator.hasNext()) {
                entry = iterator.next();
                key = entry.getKey();
                if(!tempMap.containsKey(key)){
                    iterator.remove();
                }else{
                    int tempVal = tempMap.get(key);
                    map.put(key, entry.getValue() > tempVal ? tempVal : entry.getValue());
                }
            }

        }


        Integer num;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            num = entry.getValue();
            for (int i = 0; i < num; i++) {
                result.add(entry.getKey().toString());
            }
        }

        return result;

    }


    public static void main(String[] args) {

        String[] arr = {"bella","label","roller"};
        System.out.println(commonChars(arr));
    }


}