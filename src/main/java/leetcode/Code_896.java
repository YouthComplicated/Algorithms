package leetcode;

/**
 * @author: nj
 * @date: 2020-04-30 16:01
 * @version: 0.0.1
 */
public class Code_896 {


    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.
     *
     * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if
     * for all i <= j, A[i] >= A[j].
     *
     * Return true if and only if the given array A is monotonic.
     *
     * Example 1:
     *
     * Input: [1,2,2,3]
     * Output: true
     * Example 2:
     *
     * Input: [6,5,4,4]
     * Output: true
     * Example 3:
     *
     * Input: [1,3,2]
     * Output: false
     * Example 4:
     *
     * Input: [1,2,4,5]
     * Output: true
     * Example 5:
     *
     * Input: [1,1,1]
     * Output: true
     *
     *
     * Note:
     *
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     *
     *
     *
     *
     */

    
    public static boolean isMonotonic(int[] A) {
        if(A == null || A.length == 1){
            return false;
        }
        int diff = 0,diffTemp;
        for (int i = 1; i < A.length; i++) {
            diffTemp = A[i] - A[i - 1];
            if(diff < 0 &&  diffTemp > 0){
                return false;
            }else if(diff > 0 && diffTemp < 0){
                return false;
            }else{
                if(diffTemp != 0){
                    diff = diffTemp;
                }
            }
        }
        return true;
    }

    public boolean isMonotonic1(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,1,0,1};
        System.out.println(isMonotonic(arr1));

        int[] arr2 = {1,3, 3,4,3};
        System.out.println(isMonotonic(arr2));

    }





}