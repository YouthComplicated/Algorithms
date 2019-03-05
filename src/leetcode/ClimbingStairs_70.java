package leetcode;

public class ClimbingStairs_70 {


    /**
     *
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     */

    /**
     * 穷举法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int k = 0, j = 0, result = 0;
        while(j >=  0){
            j = n - k*2;
            if(j == n || j == 0){
                result += 1;
            }else{
                //遇到了一个排列组合问题
            }
            k++;
        }
        return result;
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if( n == 1 || n == 2){
            return n;
        }
        int n1 = 1, n2 = 2;
        int temp = 0;
        for(int i = 3; i <= n; i++){
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
