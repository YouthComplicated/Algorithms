package leetcode;

public class MergeSortedArray_88 {
    /**
     Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     Note:
     The number of elements initialized in nums1 and nums2 are m and n respectively.
     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     Example:

     Input:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     Output: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //比较大小 移动数组or不移动
        for(int i = 0; i < nums2.length; i++){
            for(int j = 0; j < nums1.length; j++){
                if(nums1[j] >= nums2[i]){
                    //移动数组
                    for(int k = m-j; k < m-j; k++){
                    }
                }else{
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
