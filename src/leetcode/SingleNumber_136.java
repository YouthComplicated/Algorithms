package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     *
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * Example 1:
     *
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: [4,1,2,1,2]
     * Output: 4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.get(i) == null){
                map.put(i, 1);
            }else{
                map.remove(i);
//                map.put(i,map.get(i)+1);
            }
        }
        return map.keySet().iterator().next();
    }


    public static void main(String[] args) {


    }
}
