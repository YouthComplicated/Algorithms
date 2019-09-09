package leetcode;

import java.util.Arrays;

public class DistributeCandies_575 {

    /**
     * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
     * Example 1:
     * Input: candies = [1,1,2,2,3,3]
     * Output: 3
     * Explanation:
     * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
     * The sister has three different kinds of candies.
     * Example 2:
     * Input: candies = [1,1,2,3]
     * Output: 2
     * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
     * The sister has two different kinds of candies, the brother has only one kind of candies.
     * Note:
     *
     * The length of the given array is in range [2, 10,000], and will be even.
     * The number in given array is in range [-100,000, 100,000].
     */

    public static  int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int num = 1;
        for(int i = 1; i < candies.length; i++){
            if(num == candies.length/2 ){
                break;
            }
            if(candies[i] != candies[i-1]){
                num++;
            }
        }
        return num;
    }

    /**
     * 实际上还是使用数组去统计字母个数
     *
     * 先分配内存，然后在统计
     * @param candies
     * @return
     */
    public static int distributeCandies1(int[] candies) {
        int maxNum = candies.length >> 1;
        boolean[] exists = new boolean[200001];
        int uniqueNum = 0;
        for(int candy : candies){
            if(!exists[candy + 100000]){
                exists[candy + 100000] = true;
                if(++uniqueNum == maxNum){
                    return maxNum;
                }
            }
        }
        return uniqueNum;
    }


    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3,3};
        System.out.println(distributeCandies(arr1));
        int[] arr2 = {1,1,2,3};
        System.out.println(distributeCandies(arr2));
//        int[] arr3 = {};
//        System.out.println(distributeCandies(arr3));

    }

}
