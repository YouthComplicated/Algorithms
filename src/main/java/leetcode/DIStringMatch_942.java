package leetcode;

import java.util.Arrays;

public class DIStringMatch_942 {


    /**
     *
     * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
     *
     * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
     *
     * If S[i] == "I", then A[i] < A[i+1]
     * If S[i] == "D", then A[i] > A[i+1]
     *
     *
     * Example 1:
     *
     * Input: "IDID"
     * Output: [0,4,1,3,2]
     * Example 2:
     *
     * Input: "III"
     * Output: [0,1,2,3]
     * Example 3:
     *
     * Input: "DDI"
     * Output: [3,2,0,1]
     *
     *
     * Note:
     *
     * 1 <= S.length <= 10000
     * S only contains characters "I" or "D".
     */


    public static int[] diStringMatch(String S) {
        char [] chars = S.toCharArray();
        int max = chars.length, min = 0;
        int [] result = new int[chars.length+1];
        if(chars[0] == 'I'){
            result[0] = min;
            min ++;
        }else{
            result[0] = max;
            max --;
        }
        char a,b;
        int i = 1;
        for(; i < chars.length; i++){
            a = chars[i];
            b = chars[i - 1];
            if(a == b){
                if(a == 'I'){
                    result[i] = result[i-1] + 1;
                    min ++;
                }else{
                    result[i] = result[i-1] - 1;
                    max --;
                }
            }else{
                if(a == 'I'){
                    result[i] = min;
                    min++;
                }else{
                    result[i] = max;
                    max--;
                }
            }
        }
        if(chars[chars.length - 1] == 'I'){
            result[i] = result[i-1] + 1;
        }else{
            result[i] = result[i-1] - 1;
        }
        return result;
    }



    public static int[] diStringMatch1(String S) {

        int len = S.length();
        int start=0, end=len;
        int[] arr = new int[len + 1];
        for(int i = 0; i< len; ++i){
            if(S.charAt(i) == 'I')
                arr[i] = start++;
            else
                arr[i] = end--;
        }
        arr[len] = start;
        return arr;

    }

    public static int[] diStringMatch2(String S) {

        int a [] = new int[S.length()+1];

        int Icount = 0;
        int Dcount = S.length();
        char [] StoA = S.toCharArray();
        for(int i=0; i<=StoA.length-1; i++){
            if(StoA[i] == 'D'){
                a[i] = Dcount;
                Dcount--;
            }else {
                a[i] = Icount;
                Icount++;
            }

        }
        a[S.length()] = Icount;
        return a;


    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
        System.out.println(Arrays.toString(diStringMatch("IIDI")));

    }



}
