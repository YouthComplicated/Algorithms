package leetcode;

import java.util.Arrays;

public class ConstructRectangle_492 {

    /**
     * For a web developer, it is very important to know how to design a web page's size.
     * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page,
     * whose length L and width W satisfy the following requirements:
     *
     * 1. The area of the rectangular web page you designed must equal to the given target area.
     *
     * 2. The width W should not be larger than the length L, which means L >= W.
     *
     * 3. The difference between length L and width W should be as small as possible.
     * You need to output the length L and the width W of the web page you designed in sequence.
     * Example:
     * Input: 4
     * Output: [2, 2]
     * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
     * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2].
     * So the length L is 2, and the width W is 2.
     * Note:
     * The given area won't exceed 10,000,000 and is a positive integer
     * The web page's width and length you designed must be positive integers.
     */

    public static int[] constructRectangle(int area) {

        int w = ((Double)Math.floor(Math.sqrt(area))).intValue();
        int l = w;
        while (w * l != area){
            l++;
            if(area % l == 0){
                w =  area / l;
                break;
            }
        }
        return new int[]{l,w};
    }



    public static int[] constructRectangle1(int area) {
        for (int i = (int)Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{Math.max(i, area/i), Math.min(i, area/i)};
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(5)));
        System.out.println(Arrays.toString(constructRectangle(6)));
        System.out.println(Arrays.toString(constructRectangle(9)));
        System.out.println(Arrays.toString(constructRectangle(1)));
        System.out.println(Arrays.toString(constructRectangle(0)));


    }
}
