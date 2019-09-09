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
     */


    /**
     * 使用map 可以实现，但是集合内部大量的数组扩容和缩容，浪费空间以及时间
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

    /**
     * 交换位置，在给定的数组中查找如果找到就交换位置，继续寻找，没有则返回。
     * 还是比较慢 取决于单独数字出现的位置如果最后时间复杂度越高，并且有元素交换的损失
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int j = 0,i = 1;
        int temp;
        while(true){
            for(; i < nums.length; i++){
                if(nums[j] == nums[i]){
                    if(j + 1 != i){
                        //交换元素
                        temp = nums[i];
                        nums[i] = nums[j+1];
                        nums[j+1] = temp;
                    }
                    j += 2;
                    i = j+1;
                    break;
                }
            }
            if(i == nums.length){
                return nums[j];
            }
        }

    }

    /**
     * 1进行排序 然后寻找
     * @param args
     */


    /**
     * 速度最快利用相同两个数异或为0的特性
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(Integer n: nums) {
            res ^= n;
        }
        return res;
    }


    public static void main(String[] args) {
        //4,1,2,1,2
        SingleNumber_136 single  = new SingleNumber_136();

        System.out.println(single.singleNumber1(new int[]{4,1,2,1,2}));

//        System.out.println(single.singleNumber1(new int[]{1,0,1}));

    }
}
