package leetcode;

/**
 * @author NJ
 * @date 2019/2/26 14:22
 */
public class MaximumSubarray_53 {

    /**
     *
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     *
     * Example:
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * 穷举法 性能太慢
     */
    public int maxSubArray(int[] nums) {

        int sum;
        int maxResult = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum = nums[i];
            if(maxResult < sum){
                maxResult = sum;
            }
            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if(maxResult < sum){
                    maxResult = sum;
                }
            }
        }
        return maxResult;
    }


    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            sum = sum + i;
            max = Math.max(max, sum);
            /**
             *  如果为负数则重置为0
             */
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public int maxSubArray3(int[] nums) {
        int maxSum=nums[0],thisSum=nums[0];
        for(int i = 1; i < nums.length; i++){
            if(thisSum < 0) {
                thisSum = nums[i];
            } else {
                thisSum += nums[i];
            }
            if(thisSum > maxSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
//        int [] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int [] arr = new int[]{-4,-2,-1};
//        System.out.println(maximumSubarray_53.maxSubArray(arr));
        System.out.println(maximumSubarray_53.maxSubArray1(arr));
    }
}
