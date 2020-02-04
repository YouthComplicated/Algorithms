package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-01-04 20:40
 * @version: 0.0.1
 */
public class FindNUniqueIntegersSum_1304 {

    /**
     * Given an integer n, return any array containing n unique integers such that they add up to 0.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 5
     * Output: [-7,-1,1,3,4]
     * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
     * Example 2:
     *
     * Input: n = 3
     * Output: [-1,0,1]
     * Example 3:
     *
     * Input: n = 1
     * Output: [0]
     */



    public static  int[] sumZero(int n) {
        if(n < 1 || n > 1000){
            return null;
        }
        int[] result = new int[n];
        int k = n / 2;
        boolean isOdd = n % 2 == 0 ? true : false;
        for(int i = 0; i < n; i++){
            result[i] = k;
            k--;
            if(isOdd && k == 0){
                k--;
            }
        }
        return result;

    }

    public static  int[] sumZero1(int n) {
        int[] arr = new int[n];
        for (int i = 1; i < n/2 + 1; i++) {
            arr[2*i-2] = i;
            arr[2*i-1] = -i;
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero1(1)));
        System.out.println(Arrays.toString(sumZero1(2)));
        System.out.println(Arrays.toString(sumZero1(3)));
        System.out.println(Arrays.toString(sumZero1(4)));
        System.out.println(Arrays.toString(sumZero1(5)));
        System.out.println(Arrays.toString(sumZero1(6)));
    }




}