package leetcode;

public class BinaryGap_868 {

    /**
     * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
     *
     * If there aren't two consecutive 1's, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: 22
     * Output: 2
     * Explanation:
     * 22 in binary is 0b10110.
     * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
     * The first consecutive pair of 1's have distance 2.
     * The second consecutive pair of 1's have distance 1.
     * The answer is the largest of these two distances, which is 2.
     * Example 2:
     *
     * Input: 5
     * Output: 2
     * Explanation:
     * 5 in binary is 0b101.
     * Example 3:
     *
     * Input: 6
     * Output: 1
     * Explanation:
     * 6 in binary is 0b110.
     * Example 4:
     *
     * Input: 8
     * Output: 0
     * Explanation:
     * 8 in binary is 0b1000.
     * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
     *
     *
     * Note:
     *
     * 1 <= N <= 10^9
     */

    public static int binaryGap(int N) {
        int n = N % 2;
        N = N / 2;
        boolean flag = n == 1 ? true : false;
        int result = 0,temp = 0;
        while ( N != 0){
            if(flag){
                //往前查找，遇到0 +1 遇到1 结束 重置新的结果
                if(N % 2 == 0){
                    temp ++;
                }else{
                    temp ++;
                    if(result < temp){
                        result = temp;
                    }
                    temp = 0;
                }
            }else{
                //继续寻找直到遇上1开始进入上面的逻辑
                if( N % 2 == 1){
                    flag = true;
                }
            }
            N = N / 2;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(binaryGap(22));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(3));

    }




}
