package leetcode;

public class Sqrt_69 {
    /**
     *
     * Implement int sqrt(int x).
     *
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer
     * part of the result is returned.
     *
     * Example 1:
     *
     * Input: 4
     * Output: 2
     * Example 2:
     *
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     *              the decimal part is truncated, 2 is returned.
     */
    /**
     * 采用二分法实现无限逼近
     * @param x
     * @return
     */

    public int mySqrt(int x) {
        int low = 0, mid;
        int high = x;
        int temp;
        while(true){
            mid = (low+ high) / 2 ;
            temp = mid * mid;
            System.out.println("low:"+ low+" high:"+high);
            if(temp > x){
                high = mid;
            }else if(temp == x){
                return mid;
            }else{
                low =  mid;
            }
            // 很low
            if(Math.abs(low-high) == 1){
                break;
            }
        }
        if(high * high <= x ){
            return high;
        }else{
            return low;
        }
    }

    public int mySqrt1(int x) {
        if (x <= 1) return x;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right - 1;
    }



    public static void main(String[] args) {
        Sqrt_69 sqrt_69 = new Sqrt_69();
        System.out.println(sqrt_69.mySqrt(2147395599));

    }


}
