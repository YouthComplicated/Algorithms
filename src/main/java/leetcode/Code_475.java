package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-31 16:59
 * @version: 0.0.1
 */
public class Code_475 {

    /**
     * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
     *
     * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that
     * all houses could be covered by those heaters.
     *
     * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
     *
     * Note:
     *
     * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     * As long as a house is in the heaters' warm radius range, it can be warmed.
     * All the heaters follow your radius standard and the warm radius will the same.
     *
     *
     * Example 1:
     *
     * Input: [1,2,3],[2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses
     * can be warmed.
     *
     *
     * heaters start end
     *
     * start = startSource
     *
     * end = endSource
     *
     *
     *
     *
     */


    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int houseLen = houses.length, heaterLen = heaters.length;
        int start = houses[0], temp, end, i = 1;
        int maxNum = heaters[0] - start;
        for (; i < heaterLen
                && heaters[i] <= houses[houseLen - 1] ; i++) {
            start = heaters[i - 1];
            end = heaters[i];
            temp = (end - start) / 2;
            if(temp > maxNum){
                maxNum = temp;
            }
//            System.out.println("start" + start);
        }
        temp = houses[houses.length - 1] - heaters[i - 1];
        if(temp > maxNum){
            maxNum = temp;
        }
        return maxNum;
    }

    public int findRadius123(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }


    public static int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int idx = 0;
        int left = -heaters[0];
        int right = heaters[0];
        for(int house: houses){
            while(house > right){
                left = right;
                right = idx+1 < heaters.length ? heaters[++idx]:Integer.MAX_VALUE;
            }
            if(left < house-res && right > house+res){
                if(left < 0){
                    res = Math.abs(house-right);
                }else if(right == Integer.MAX_VALUE){
                    res = Math.abs(house-left);
                }else{
                    res = Math.min(Math.abs(house-right), Math.abs(house-left));
                }
            }
        }
        return res;
    }





    public static void main(String[] args) {
        int[] s1 = {1,2,3};
        int[] t1 = {2};
        System.out.println(findRadius(s1,t1));

        int[] s2 = {1,2,3,4};
        int[] t2 = {1,4};
        System.out.println(findRadius(s2,t2));

        int[] s3 = {1,5};
        int[] t3 = {2};
        System.out.println(findRadius(s3,t3));


        int[] s4 = {1,2,3,5,15};
        int[] t4 = {2,30};
        System.out.println(findRadius(s4,t4));


        int[] s5 = {1,1,1,1,1,1,999,999,999,999,999};
        int[] t5 = {499,500,501};
        System.out.println(findRadius(s5,t5));

        int[] s6 = {1,2,3,4,5,6,7,8,9,10};
        int[] t6 = {2,9};
        System.out.println(findRadius(s6,t6));

        int[] s7 = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] t7 = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(s7,t7));
    }
}