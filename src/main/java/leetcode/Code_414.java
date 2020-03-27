package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 19:27
 * @version: 0.0.1
 */
public class Code_414 {

    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist,
     * return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     *
     * Output: 1
     *
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     *
     * Output: 2
     *
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     *
     * Output: 1
     *
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     *
     *
     *
     */
    public static int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            }else if(nums[i] > secondMax && nums[i] < max){
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(nums[i] > thirdMax && nums[i] < secondMax){
                thirdMax = nums[i];
            }
        }
//        System.out.println("max:" + max + ",second:" + secondMax + ",third:"+thirdMax);
        return (int)(thirdMax == Long.MIN_VALUE ? max : thirdMax);
    }

    public static void main(String[] args) {

        int [] a = {2, 4, 6};
        System.out.println(thirdMax(a));

        int [] a1 = {1, 2};
        System.out.println(thirdMax(a1));

        int [] a2 = {2, 2, 3, 1, 9, 6};
        System.out.println(thirdMax(a2));

        int [] a3 = {1,1};
        System.out.println(thirdMax(a3));

        int [] a4 = {2,2,3,1};
        System.out.println(thirdMax(a4));
    }



}











