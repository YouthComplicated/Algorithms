package leetcode;

import java.util.Arrays;

public class DuplicateZeros_1089 {

    /**
     * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
     *
     * Note that elements beyond the length of the original array are not written.
     *
     * Do the above modifications to the input array in place, do not return anything from your function.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,0,2,3,0,4,5,0]
     * Output: null
     * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
     * Example 2:
     *
     * Input: [1,2,3]
     * Output: null
     * Explanation: After calling your function, the input array is modified to: [1,2,3]
     *
     *
     * Note:
     *
     * 1 <= arr.length <= 10000
     * 0 <= arr[i] <= 9
     */

    public static int[] duplicateZeros(int[] arr) {
        int [] result = new int[arr.length];
        int k = 0;
        for(int i = 0; i < arr.length && k < arr.length; i++){
            result[k++] = arr[i];

            if(arr[i] == 0){
                result[k++] = 0;
            }
        }
        arr = result;
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void duplicateZeros1(int[] arr) {
        int k;for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                for( k = arr.length - 1; k > i; k--){
                    arr[k] = arr[k-1];
                }
                arr[k] = 0;
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int [] arr ={1,0,2,3,0,4,5,0};
        duplicateZeros1(arr);
        int [] arr1 ={1,0,2,3,0,4,5,0};
    }
}
