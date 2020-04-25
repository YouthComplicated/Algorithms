package leetcode;

/**
 * @author: nj
 * @date: 2020-04-18 14:48
 * @version: 0.0.1
 */
public class Code_633 {
    /**
     *
     *
     * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
     *
     * Example 1:
     *
     * Input: 5
     * Output: True
     * Explanation: 1 * 1 + 2 * 2 = 5
     *
     *
     * Example 2:
     *
     * Input: 3
     * Output: False
     *
     *
     *
     *
     *
     */
    public static boolean judgeSquareSum(int c) {

        int end = (int)Math.sqrt(c), start = 0, multi;
        boolean flag = false;
        while (end > start){
            multi = end * end  + start * start;
            if(multi > c){
                end --;
                start = 0;
            }else if(multi < c){
                start ++;
            }else{
                flag = true;
                break;
            }
        }
        return flag;

    }


    public boolean judgeSquareSum11(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b)
                return true;
        }
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(17));
        System.out.println(judgeSquareSum(61));

    }













}