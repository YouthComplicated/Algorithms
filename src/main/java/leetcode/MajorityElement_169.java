package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    /**
     * Given an array of size n, find the majority element. The majority element
     * is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element
     * always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */


    /**
     * 1、利用数组的下标进行统计(没有指定元素中的范围所以舍弃)
     *
     *
     * 2、使用集合map
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int temp, max = nums.length / 2;
        Integer value;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            value = map.get(temp);
            if(value != null){
                map.put(temp, value+1);
                if(value + 1 > max){
                    return temp;
                }
            }else{
                map.put(temp, 1);
            }
        }

//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() > max){
//                return entry.getKey();
//            }
//        }

        return 0;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        long start = System.currentTimeMillis();
//        int [] a = new int[Integer.MAX_VALUE-1];
//        for(int i = 0; i < Integer.MAX_VALUE; i++){
////            System.out.println();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("耗时："+ (end - start));

        int [] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));
        int [] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));


    }

}
