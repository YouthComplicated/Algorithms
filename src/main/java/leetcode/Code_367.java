package leetcode;

/**
 * @author: nj
 * @date: 2020-03-25 20:38
 * @version: 0.0.1
 */
public class Code_367 {

    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     *
     * Note: Do not use any built-in library function such as sqrt.
     *
     * Example 1:
     *
     * Input: 16
     * Output: true
     * Example 2:
     *
     * Input: 14
     * Output: false
     *
     *
     * 二分法问题
     *
     *
     */
    public static boolean isPerfectSquare(int num) {
        if(num < 2){
            return true;
        }
        int start = 1, end = num / 2;
        long l;
        while (start < end){
            l = start * start;
            if(l == num){
                return true;
            }else if(l < num){
                start++;
            }else {
                return false;
            }
        }
        return false;
    }


    public boolean isPerfectSquare11(int num) {
        int left = 0;
        int right = num / 2 + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long prod = mid * mid;
            if (prod == num) {
                return true;
            }
            if (prod > num) {
                right = (int) mid;
            } else {
                left = (int) mid + 1;
            }
        }
        return left == 1;
    }


    public static boolean isPerfectSquare1(int num) {
        if(num < 2){
            return true;
        }
        int start = num / 2;
        long l;
        while ((l = start * start) > num){
            if(l == num){
                return true;
            }else if(l < num){
                break;
            }else {
                start /= 2;
            }
        }
//        long start
//        for (int i = start + 1; ; i++) {
//            if(start * start == num){
//                return true;
//            }else i
//        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(0));
        System.out.println(isPerfectSquare(2));

        System.out.println(Math.sqrt(0));

        int a = Integer.MAX_VALUE/2;
        int aa = a * a;
        long bb = a * a;
        System.out.println(aa);
        System.out.println(bb);
    }

}