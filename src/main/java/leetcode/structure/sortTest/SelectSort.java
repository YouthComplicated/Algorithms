package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 * 选择排序  每次保证前面i个数有序， 找最小，每趟交换次数<=1
 *
 * 10万条数据  2-3s左右 mac
 *
 * @author: nj
 * @date: 2020-05-17 17:18
 * @version: 0.0.1
 */
public class SelectSort {

    /**
     * 给定范围找到最小与第i个交换 每次最多只交换一次
     * @param arr
     */
    public static void sort(int[] arr){
        int min, index, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            if(index != i){
               temp = arr[i];
               arr[i] = arr[index];
               arr[index] = temp;
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