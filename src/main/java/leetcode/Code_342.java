package leetcode;

/**
 * @author: nj
 * @date: 2020-03-23 14:37
 * @version: 0.0.1
 */
public class Code_342 {


    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
     *
     * Example 1:
     *
     * Input: 16
     * Output: true
     * Example 2:
     *
     * Input: 5
     * Output: false
     * Follow up: Could you solve it without loops/recursion?
     */

    public boolean isPowerOfFour(int num) {
        if(num == 0 || num == 2){
            return false;
        }
        return num > 0 && 1073741824 % num == 0;
    }

    public static void main(String[] args) {


        double l = Math.pow(4,14);

        System.out.println((int)l);

        int t = 1;
        for(int i = 0; i < 20; i++){
            t *= 4;
            System.out.println(t);
        }

        System.out.println(t);

    }





}