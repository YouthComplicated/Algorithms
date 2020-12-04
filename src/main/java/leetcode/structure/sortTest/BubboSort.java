package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 * 冒泡排序
 *
 * 核心思想：两两比较，每趟保证倒数i个有序， 但是交换次数过多
 *
 * 10万条数据  12-15s左右 mac
 *
 * @author: nj
 * @date: 2020-05-17 16:59
 * @version: 0.0.1
 */
public class BubboSort {

    public static void sort(int[] arr){

        int temp;
        boolean flag = false;
        // n - 1 趟
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,1,3,7,9,12,0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int max = 100000;
        int[] arr1 = new int[max];
        for (int i = 0; i < max; i++) {
            arr1[i] = (int)(Math.random()*max);
        }

        long t = System.currentTimeMillis();
        sort(arr1);
        System.out.println("耗时："+ (System.currentTimeMillis() - t) /1000 + "秒");

    }


}