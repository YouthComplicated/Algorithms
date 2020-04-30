package leetcode;

import java.util.*;

/**
 * @author: nj
 * @date: 2020-04-29 20:19
 * @version: 0.0.1
 */
public class Code_884 {


    /**
     *
     * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only
     * of lowercase letters.)
     *
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     *
     * Return a list of all uncommon words.
     *
     * You may return the list in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: A = "this apple is sweet", B = "this apple is sour"
     * Output: ["sweet","sour"]
     * Example 2:
     *
     * Input: A = "apple apple", B = "banana"
     * Output: ["banana"]
     *
     *
     * Note:
     *
     * 0 <= A.length <= 200
     * 0 <= B.length <= 200
     * A and B both contain only spaces and lowercase letters.
     *
     */

    public static String[] uncommonFromSentences(String A, String B) {
        String[] arr1 = A.split(" ");
        Map<String,Integer> mapA = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            mapA.put(arr1[i], mapA.getOrDefault(arr1[i], 0) + 1);
        }

        String[] arr2 = B.split(" ");
        Map<String,Integer> mapB = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            mapB.put(arr2[i], mapB.getOrDefault(arr2[i], 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mapA.entrySet()){
            if(entry.getValue() == 1 && !mapB.containsKey(entry.getKey())){
                list.add(entry.getKey());
            }else{
                mapB.remove(entry.getKey());
            }
        }

        for(Map.Entry<String, Integer> entry : mapB.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }


        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }


        return ans;
    }


    public String[] uncommonFromSentences1(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word : B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word : count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }



    public static void main(String[] args) {

        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));

    }



}