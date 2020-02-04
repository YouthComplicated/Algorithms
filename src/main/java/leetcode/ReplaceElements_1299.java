package leetcode;

import base.Arrays.Array;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-01-04 21:20
 * @version: 0.0.1
 */
public class ReplaceElements_1299 {

    /**
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     *
     * After doing so, return the array.

     *
     * Example 1:
     *
     * Input: arr = [17,18,5,4,6,1]
     * Output:      [18,6,6,6,1,-1]
     *
     * arr = [17,18,6,4,6,1]
     *
     *            ,6,6,6,-1]
     *       [1,1,1,1]
     *             2,-1]
     * Constraints:
     *
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i] <= 10^5
     *
     */


    public static int[] replaceElements(int[] arr) {
        System.out.println("s:"+ Arrays.toString(arr));
        int before = arr[arr.length-1];
        arr[arr.length-1] = -1;
        int t;
        for(int k = arr.length - 2; k >= 0; k--){
            if(before < arr[k]){
                t = arr[k];
                arr[k] = before;
                before = t;
            }else if(before == arr[k] && k != 0){
                t = arr[k];
                arr[k] = before - 1;
                before = t;
            }else {
                arr[k] = before;
            }
        }
        System.out.println("t:"+ Arrays.toString(arr));
        return arr;
    }


    public static int[] replaceElements1(int[] arr){
//            System.out.println("s:"+ Arrays.toString(arr));
            int max = 0;
            int temp;
            for (int i = arr.length-1; i >= 0; i--)
            {
                if (i == arr.length-1)
                {
                    max = arr[i];
                    arr[i] = -1;
                }

                else if (arr[i] > max)
                {
                    temp = arr[i];
                    arr[i] = max;
                    max = temp;
                }

                else
                {
                    arr[i] = max;
                }
            }
//        System.out.println("t:"+ Arrays.toString(arr));
            return arr;

    }

    public static void main(String[] args) {
        int [] arr1 = {17,18,5,4,6,1};
        int [] arr2 = {1,1,1};
        int [] arr3 = {6,4,6,4,3,2,2,1,1,1};
        int [] arr4 = {8,8,8};
        replaceElements(arr1);
        replaceElements(arr2);
        replaceElements(arr3);
        replaceElements(arr4);

//        System.out.println(Arrays.toString(replaceElements(arr1)));
//        System.out.println(Arrays.toString(replaceElements(arr2)));
//        System.out.println(Arrays.toString(replaceElements(arr3)));

    }
}