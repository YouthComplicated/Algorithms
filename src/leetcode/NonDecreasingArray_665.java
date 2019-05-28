package leetcode;

public class NonDecreasingArray_665 {

    /**
     * Given an array with n integers, your task is to check if it could
     * become non-decreasing by modifying at most 1 element.
     *
     * We define an array is non-decreasing
     * if array[i] <= array[i + 1] holds for every i (1 <= i < n).
     *
     * Example 1:
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     * Example 2:
     * Input: [4,2,1]
     * Output: False
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     * Note: The n belongs to [1, 10,000].
     */

    public static void main(String[] args) {
        NonDecreasingArray_665 noDecr = new NonDecreasingArray_665();
        noDecr.checkPossibility(null);

        int [] nums1 = {4,2,3};
        int [] nums2 = {4,2,1};
        int [] nums3 = {56};
        int [] nums4 = {1,5,7,9,0};
        int [] nums5 = {3,4,2,3};
        int [] nums6 = {-1,4,2,3};
        int [] nums7 = {2,3,3,2,4};

//        System.out.println(noDecr.checkPossibility(nums1));
//        System.out.println(noDecr.checkPossibility(nums2));
//        System.out.println(noDecr.checkPossibility(nums3));
//        System.out.println(noDecr.checkPossibility(nums4));
//        System.out.println(noDecr.checkPossibility(nums5));
//        System.out.println(noDecr.checkPossibility(nums6));
        System.out.println(noDecr.checkPossibility(nums7));

    }


    public boolean checkPossibility(int[] nums) {
        if(nums == null){
            return false;
        }
        int i = 0;
        for(int j = 0; j < nums.length - 1; j++){
            if(nums[j] > nums[j+1]){
                if(j -1 >= 0 &&  nums[j-1] > nums[j+1] && j+1 < nums.length-1){
                    return false;
                }else{
                    i++;
                }
            }
            if(i > 1){
                return false;
            }
        }
        return true;
    }
}
