package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-04-28 16:49
 * @version: 0.0.1
 */
public class Code_849 {

    /**
     * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
     *
     * There is at least one empty seat, and at least one person sitting.
     *
     * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
     *
     * Return that maximum distance to closest person.
     *
     * Example 1:
     *
     * Input: [1,0,0,0,1,0,1]
     * Output: 2
     * Explanation:
     * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
     * If Alex sits in any other open seat, the closest person has distance 1.
     * Thus, the maximum distance to the closest person is 2.
     * Example 2:
     *
     * Input: [1,0,0,0]
     * Output: 3
     * Explanation:
     * If Alex sits in the last seat, the closest person is 3 seats away.
     * This is the maximum distance possible, so the answer is 3.
     * Note:
     *
     * 1 <= seats.length <= 20000
     * seats contains only 0s or 1s, at least one 0, and at least one 1.
     *
     *
     *
     * 1、两边都有人,两边的人都得考虑 min(max.abs(left-right))
     *
     * 2、一遍有人
     *
     *
     */


    public static int maxDistToClosest(int[] seats) {

        int max = -1, start, end;
        boolean isLeftFind, isRightFind;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 0){
                start = end = i;
                isLeftFind = isRightFind = false;
                while (start >= 0){
                    if(seats[start] == 1){
                        isLeftFind = true;
                        break;
                    }
                    start--;
                }
                while (end < seats.length){
                    if(seats[end] == 1){
                        isRightFind = true;
                        break;
                    }
                    end ++;
                }
                if(isLeftFind && isRightFind){
                    int min = Math.min(i - start, end -i);
                    if(max < min){
                       max = min;
                    }
                }else if(isLeftFind){
                    max = Math.max(i - start, max);
                }else if(isRightFind){
                    max = Math.max(end - i, max);
                }

            }
        }
        return max;

    }

    public int maxDistToClosest1(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;
                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                //简化为一种情况
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        int [] arr1 = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(arr1));


        int [] arr2 = {1,0,0,0};
        System.out.println(maxDistToClosest(arr2));



    }

}