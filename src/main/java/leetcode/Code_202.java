package leetcode;

/**
 * @author: nj
 * @date: 2020-03-14 20:59
 * @version: 0.0.1
 */
public class Code_202 {

    /**
     * Write an algorithm to determine if a number is "happy".
     *
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum
     * of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly
     * in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     *
     * Example:
     *
     * Input: 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */

    /**
     *
     *
     * 如何终止循环  SET
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {



        return true;
    }

    /**
     * 以下思路是基于总会得到<10的数
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        while(n > 9){
            int sum = 0;
            int temp = 0;
            while(n > 9){
                temp = n % 10;
                n = n/10;
                sum += (temp * temp);
            }
            sum += (n * n);
            n = sum;
        }

        if (n == 1 || n == 7){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 下面方法跑的快，思路与链表
     */

//    class Solution {
//        private:
//        int getNext(int num) {
//            int totalSum = 0;
//            while (num) {
//                int digit = num % 10;
//                totalSum += pow(digit, 2);
//                num /= 10;
//            }
//            return totalSum;
//        }
//        public:
//        bool isHappy(int n) {
//            int slow = n;
//            int fast = getNext(n);
//            while (fast != 1 and slow != fast) {
//                slow = getNext(slow);
//                fast = getNext(getNext(fast));
//            }
//            return fast == 1;
//        }
//    };






}