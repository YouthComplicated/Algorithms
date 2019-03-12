package leetcode;

import java.util.Arrays;

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
        int j = 0;
        boolean needMove;
        //遍历比较的数组
        for(int i = 0; i < n; i++){
            needMove = false;
            for(; j < m; j++){
                //移动数组
                if(nums1[j] >= nums2[i]){
                    for(int k = m - 1; k >= j; k--){
                        nums1[k+1] = nums1[k];
                    }
                    m += 1;
                    nums1[j]= nums2[i];
                    needMove = true;
                    j++;
                    break;
                }
            }
            if(!needMove){
                nums1[j]= nums2[i];
                m += 1;
            }
//            System.out.println(Arrays.toString(nums1));
        }
    }

    public static void main(String[] args) {

        MergeSortedArray_88 merage = new MergeSortedArray_88();

//        int [] nums1 = new int[]{1,2,3,0,0,0};
//        int [] nums2 = new int[]{2,5,6};
//        merage.merge(nums1,3, nums2,3);

        int [] nums1 = new int[]{1,4,8,0,0,0};
        int [] nums2 = new int[]{3,5,6};

        merage.merge(nums1,3, nums2,3);

        System.out.println(Arrays.toString(nums1));




    }
}
