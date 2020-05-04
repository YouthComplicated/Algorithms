package leetcode;

/**
 * @author: nj
 * @date: 2020-05-03 17:54
 * @version: 0.0.1
 */
public class Code_941 {

    /**
     * Given an array A of integers, return true if and only if it is a valid mountain array.
     *
     * Recall that A is a mountain array if and only if:
     *
     * A.length >= 3
     * There exists some i with 0 < i < A.length - 1 such that:
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *
     *
     *
     *
     *
     */
    public static boolean validMountainArray(int[] A) {

        if(A == null || A.length < 3){
            return false;
        }
        int i = 1, j;
        for (; i < A.length - 1; i++) {
            if(A[i] == A[i - 1]){
                return false;
            }else if(A[i] < A[i - 1]){
                break;
            }
        }
        for (j = A.length - 1; j > 1; j--) {
            if(A[j] == A[j - 1]){
                return false;
            }else if(A[j] > A[j - 1]){
                break;
            }
        }
        System.out.println("j: " + j + " i:" + i);

        return j == i - 1;

    }


    public boolean validMountainArray1(int[] A) {

        int N = A.length, i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }





    public static void main(String[] args) {

        int[] A = {0,3,2,1};
//        System.out.println(validMountainArray(A));


        int[] A1 = {3,5,5,1};
//        System.out.println(validMountainArray(A1));

        int[] A2 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(A2));

        int[] A3 = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(A3));

    }





}