package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-18 10:51
 * @version: 0.0.1
 */
public class Code_628 {


    /**
     *
     *Given an integer array, find three numbers whose product is maximum and output the maximum product.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: 6
     *
     *
     * Example 2:
     *
     * Input: [1,2,3,4]
     * Output: 24
     *
     *
     * Note:
     *
     * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
     * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
     *
     *
     * 看似简单，实则😸😸😸😸😸😸😸😸😸😸  气死人
     *
     *
     * 考虑到负数的存在(lenght > 3)
     *
     *
     *  A > B > C > D
     *
     *  A > B > C >= 0  A * B * C ??? xx
     *
     *  A > B > 0 > C > D   C * D * A
     *
     *  A > 0 > B > C > D  C * D * A
     *
     *  0 > A > B > C >
     *
     *
     *
     *  Math.max(nums[0]*nums[1]*nums[n],nums[n]*nums[n-1]*nums[n-2]);
     *
     *
     *  第一大 第二大 第三大  .... 第三小 第二小 第一小
     *
     */


    public static int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int len = nums.length;
        if(len == 3){
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int a = nums[len - 1], b = nums[len - 2], c = nums[len - 3], d = nums[len - 4];
        if(b > 0 &&  c < 0){
            return a * nums[0] * nums[1];
        }else if(b < 0 && a > 0){
            return a * nums[0] * nums[1];
        }else{
            return Math.max(a * b * c, a * nums[0] * nums[1]);
        }
    }

    public int maximumProduct1(int[] nums) {

        if(nums==null || nums.length<3) return 0;
        Arrays.sort(nums);
        int n=nums.length-1;

        return Math.max(nums[0]*nums[1]*nums[n],nums[n]*nums[n-1]*nums[n-2]);
    }


    public int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE; // 第1大
        int max2 = Integer.MIN_VALUE; // 第2大
        int max3 = Integer.MIN_VALUE; // 第3大
        int min2 = Integer.MAX_VALUE; // 第2小
        int min1 = Integer.MAX_VALUE; // 第1小

        for(int num : nums){
            // max
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max3 = max2;
                max2 = num;
            }else if(num > max3){
                max3 = num;
            }
            // min
            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = num;
            }
        }
        return Math.max(max3 * max2 * max1, min1 * min2 * max1);
    }


    public static void main(String[] args) {

        int[] a = {-4,-3,-2,-1,60};
        int[] b = {-4,-3,-2,-1,69,80};
        int[] c = {-4,-3,-2,-1};

        System.out.println(maximumProduct(a));
        System.out.println(maximumProduct(b));
        System.out.println(maximumProduct(c));

        int[] d = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        Arrays.sort(d);
        System.out.println(maximumProduct(d));
//        System.out.println(Arrays.toString(d));

    }
}