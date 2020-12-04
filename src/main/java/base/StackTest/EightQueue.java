package base.StackTest;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-05-14 21:08
 * @version: 0.0.1
 */
public class EightQueue {

//    static Integer i = 0;

    int max = 8;

    int[] arr = new int[max];

    static int count = 0;

    static int t = 0;


    public void queue(int n){

        if(n == 8){
            t++;
//            System.out.println(arr);
            System.out.println(Arrays.toString(arr));
            return;
        }

        /**
         * 每个位置都要尝试放置0到7
         */
        for (int j = 0; j < max; j++) {
            //放置第n个皇后到j列
            arr[n] = j;
            if(judge(n)){
                queue(n+1);
            }
        }




    }


    /**
     *
     * 判断第n个皇后与n-1是否有冲突
     *
     *  1、判断是否在同一列上
     *
     *  2、判断是否在对角线上
     *
     *  3、同一行上无需判断
     *
     */
    public  boolean judge(int n){
        count ++;
        for (int j = 0; j < n; j++) {
            if(arr[j] == arr[n] || Math.abs(n-j) == Math.abs(arr[n] - arr[j])){
                return false;
            }
        }
        return true;

    }



//    public static void queue(int arr[], int n){
//        for (int i = 0; i < arr.length; i++) {
//
//            if(arr[i] > 0){
//                continue;
//            }else{
//                n = n + 1;
//                arr[i] = n;
//                queue(arr, n + 1);
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        if(n == 8){
//            i++;
//        }
//        return;
//    }




    public static void main(String[] args) {

        EightQueue a = new EightQueue();
        a.queue(0);

        System.out.printf("总共有%d解法：",t);
        System.out.printf("判断冲突次数%d：",count);

    }





}