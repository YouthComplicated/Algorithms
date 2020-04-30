package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-04-28 20:10
 * @version: 0.0.1
 */
public class Code_874 {


    /**
     *
     * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible
     * types of commands:
     *
     * -2: turn left 90 degrees
     * -1: turn right 90 degrees
     * 1 <= x <= 9: move forward x units
     * Some of the grid squares are obstacles.
     *
     * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
     *
     * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues
     * following the rest of the route.)
     *
     * Return the square of the maximum Euclidean distance that the robot will be from the origin.
     *
     *
     * Example 1:
     *
     * Input: commands = [4,-1,3], obstacles = []
     * Output: 25
     * Explanation: robot will go to (3, 4)
     * Example 2:
     *
     * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * Output: 65
     * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
     *
     *
     * Note:
     *
     * 0 <= commands.length <= 10000
     * 0 <= obstacles.length <= 10000
     * -30000 <= obstacle[i][0] <= 30000
     * -30000 <= obstacle[i][1] <= 30000
     * The answer is guaranteed to be less than 2 ^ 31.
     *
     *
     * 障碍物：不动，挑出循环
     *
     *
     * -2 (x - t, y)  left
     *
     * -1 (x + t, y)  right
     *
     *  x +-
     *  y +-
     *
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        /**
         * 定义四个方向所代表的值
         *
         * 1 north  y+n
         *
         * 2 east   x+n
         *
         * 3 south  y-n
         *
         * 4 west   x-n
         *
         */
        int direction = 1,max = 0;
        int [] arr = {0,0};
        for (int i = 0; i < commands.length; i++) {
            if(commands[i] == -2 || commands[i] ==  -1){
                direction = getDirection(direction, commands[i]);
            }else{
                arr = move(commands[i], direction, arr, obstacles);
                max = Math.max(max, arr[0] * arr[0] + arr[1] * arr[1]);
            }
//            System.out.println(Arrays.toString(arr));
        }
        return max;
    }

    private int[] move(int space, int direction, int[] arr, int[][] obstacles){
        int[] temp;
        for(int i = 1; i <= space; i++){
            temp = Arrays.copyOf(arr,2);
            if(direction == 1){
                arr[1] += 1;

            }else if(direction == 2){
                arr[0] += 1;

            }else if(direction == 3){
                arr[1] -= 1;

            }else{
                arr[0] -= 1;

            }
            System.out.println(Arrays.toString(arr));
            if(isObstacle(arr, obstacles)){
                return temp;
            }
        }
        System.out.println();
        return arr;
    }

    private int getDirection(int direction, int commonds){
        switch (commonds){
            case -2 :
                if(direction == 1){
                    direction = 4;
                }else if(direction == 2){
                    direction = 1;
                }else if(direction == 3){
                    direction = 2;
                }else{
                    direction = 3;
                }
                break;
            case -1 :
                if(direction == 1){
                    direction = 2;
                }else if(direction == 2){
                    direction = 3;
                }else if(direction == 3){
                    direction = 4;
                }else{
                    direction = 1;
                }
                break;
        }
        return direction;

    }


    private boolean isObstacle(int[] arr, int[][] obstacles){
        for (int i = 0; i < obstacles.length; i++) {
            if(obstacles[i][0] == arr[0]
                && obstacles[i][1] == arr[1]){
                return true;
            }
        }
        return false;
    }



    public int robotSim1(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        Code_874 code874 = new Code_874();

        int[] arr1 = {4,-1,3};
        int[][] obstacles1 = {};
//        System.out.println(code874.robotSim(arr1,obstacles1));

        int[] arr2 = {4,-1,4,-2,4};
        int[][] obstacles2 = {{2,4}};
        System.out.println(code874.robotSim(arr2,obstacles2));

        /**
         *
         [-2,8,3,7,-1]
         [[-4,-1],[1,-1],[1,4],[5,0],[4,5],[-2,-1],[2,-5],[5,1],[-3,-1],[5,-3]]
         */

        /**
         * -2(left)  -1(right)
         */

    }
}