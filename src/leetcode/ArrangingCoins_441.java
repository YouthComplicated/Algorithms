package leetcode;

public class ArrangingCoins_441 {

    /**
     * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
     *
     * Given n, find the total number of full staircase rows that can be formed.
     *
     * n is a non-negative integer and fits within the range of a 32-bit signed integer.
     *
     * Example 1:
     *
     * n = 5
     *
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤
     *
     * Because the 3rd row is incomplete, we return 2.
     * Example 2:
     *
     * n = 8
     *
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     *
     * Because the 4th row is incomplete, we return 3.
     *
     *
     *
     *
     * eg:   1+2+3+...+n  <==> sum
     *
     *      n^2+n >= 2sum  求n的最小值
     */


    /**
     * very slowly
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        long sum = 0;
        for(int i = 1; ;i++){
            sum += i;
            if(sum == n){
               return i;
            }else if(sum > n){
               return i - 1;
            }
        }
    }


    public static int arrangeCoins1(int n) {
        double t = 2.0 * n;
        double k = Math.floor(Math.sqrt(t));
        double sum;
        for(;;k++){
            sum = k * k + k;
            if(sum == t){
                return (int)k;
            }
            if(sum > t){
                return (int) (k-1);
            }
        }
    }

    public int arrangeCoins2(int n){
        return (int)Math.floor(0.5*(Math.sqrt(8*(double)n+1)-1));
    }


    public int arrangeCoins3(int n) {
        int start = 0;
        int end = 1;
        for (int i = 1; i <=16; i++) {
            end = end*2;
        }
        start = 1;
        while (start<end-1) {
            int mid = (start+end)/2;
            double totalCoin=(1+mid)*(mid/2.0);
            if (mid % 2 != 0) {
                totalCoin=(1+mid) / 2.0 * mid;
            }
            if (n < totalCoin) {
                end = mid;
            } else if (n > totalCoin) {
                start = mid;
            } else {
                return mid;
            }
        }
        double totalCoin1=(1+start)*(start/2.0);
        if (start % 2 != 0) {
            totalCoin1=(1+start) / 2.0 * start;
        }
        double totalCoin2=(1+end)*(end/2.0);
        if (end % 2 != 0) {
            totalCoin2=(1+end) / 2.0 * end;
        }
        if (totalCoin1 > n) {
            return start - 1;
        } else if (totalCoin1 <= n && totalCoin2 > n) {
            return start;
        } else if (n>=totalCoin2){
            return end;
        }
        return 0;
    }


    public static void main(String[] args) {

        /**
         * 1
         * 1
         * 2
         * 2
         * 3
         * 65535
         */
//        System.out.println(ArrangingCoins_441.arrangeCoins(1));
//        System.out.println(ArrangingCoins_441.arrangeCoins(2));
//        System.out.println(ArrangingCoins_441.arrangeCoins(3));
//        System.out.println(ArrangingCoins_441.arrangeCoins(5));
//        System.out.println(ArrangingCoins_441.arrangeCoins(8));
//        System.out.println(ArrangingCoins_441.arrangeCoins(2147483647));
        System.out.println("================");
        System.out.println(ArrangingCoins_441.arrangeCoins1(1));
        System.out.println(ArrangingCoins_441.arrangeCoins1(2));
        System.out.println(ArrangingCoins_441.arrangeCoins1(3));
        System.out.println(ArrangingCoins_441.arrangeCoins1(5));
        System.out.println(ArrangingCoins_441.arrangeCoins1(8));
        System.out.println(ArrangingCoins_441.arrangeCoins1(2147483647));



    }

}
