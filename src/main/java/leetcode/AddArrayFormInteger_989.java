package leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AddArrayFormInteger_989 {


    /**
     * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
     *
     * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
     *
     *
     *
     * Example 1:
     *
     * Input: A = [1,2,0,0], K = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     *
     * Note：
     *
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 9
     * 0 <= K <= 10000
     * If A.length > 1, then A[0] != 0
     */


    public static List<Integer> addToArrayForm(int[] A, int K) {
        char[] kArr = String.valueOf(K).toCharArray();
        int i = A.length - 1, j = kArr.length - 1, k = 0;
        int [] result = new int[i >= j ? i+2 : j+2];
        int sum,temp = 0;

        while(true){
            sum = 0;
            if( i >= 0){
                sum += A[i];
                i --;
            }

            if(j >= 0){
                sum += kArr[j] - 48;
                j --;
            }
            sum += temp;
            result[k++] = sum % 10;
            if(sum >= 10){
                temp  = 1;
            }else{
                temp = 0;
            }
            if( i < 0 && j < 0){
                break;
            }
        }

        int l;
        if(temp == 1){
            result[k] = temp;
            l = k;
        }else{
            l = k -1;
        }
        List<Integer> list = new ArrayList<>();
        for(; l >= 0; l--){
            list.add(result[l]);
        }
        return list;
    }

    public static void main(String[] args) {
//        int [] arr1 = {1,2,0,0};
//        System.out.println(AddArrayFormInteger_989.addToArrayForm(arr1,34));
//        int [] arr2 = {9,9};
//        System.out.println(AddArrayFormInteger_989.addToArrayForm(arr2,99));
//        int [] arr3 = {9,9,9};
//        System.out.println(AddArrayFormInteger_989.addToArrayForm(arr3,9));
//        int [] arr4 = {9,9};
//        System.out.println(AddArrayFormInteger_989.addToArrayForm(arr4,999));
        int [] arr5 = {2,7,4};
        System.out.println(AddArrayFormInteger_989.addToArrayForm(arr5,181));

    }
}
