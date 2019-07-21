package leetcode;

public class ContainsDuplicateII_219 {


    /**
     *
     *
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
     *
     * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */


    /**
     * very s
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int j;
//        for(int i = 0; i < nums.length; i++){
//            j = i+k;
//            for(;j > i; j--){
//                if( j <= nums.length - 1
//                        && nums[i] == nums[j]) {
//                        return true;
//                }
//            }
//        }

        for(int i = 0; i < nums.length; i++){
            j = i+1;
            for(;j < nums.length; j++){
                if(j - i <= k
                        && nums[i] == nums[j]) {
                        return true;
                }
            }
        }
        return false;




    }



    public static void main(String[] args) {

        int[] arr1 = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(arr1, 3));
        int[] arr2 = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr2, 1));
        int[] arr3 = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(arr3, 2));
        int[] arr4 = {99,99};
        System.out.println(containsNearbyDuplicate(arr4, 2));

    }

}
