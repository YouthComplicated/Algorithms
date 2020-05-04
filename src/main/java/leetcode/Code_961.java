package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-05-04 17:13
 * @version: 0.0.1
 */
public class Code_961 {


    /**
     * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     *
     * Return the element repeated N times.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,1,2,5,3,2]
     * Output: 2
     * Example 3:
     *
     * Input: [5,1,5,2,5,3,5,4]
     * Output: 5
     *
     *
     * Note:
     *
     * 4 <= A.length <= 10000
     * 0 <= A[i] < 10000
     * A.length is even
     *
     *
     */

    public int repeatedNTimes(int[] A) {

        int ans = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if(A[i] == A[j]){
                    ans = A[i];
                    break;
                }
            }
        }
        return ans;

    }

    public int repeatedNTimes1(int[] A) {

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            if(set.contains(a)){
                ans = a;
                break;
            }else{
                set.add(a);
            }
        }

        return ans;

    }


    public static void main(String[] args) {


    }
}