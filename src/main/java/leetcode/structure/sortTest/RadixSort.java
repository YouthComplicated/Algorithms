package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 * 基数排序 稳定排序
 *
 * 每次排序按照数字相应位的数放入相应的10个桶中，相应位数从低位到高位
 * 一共需要排序中最大数有多少位 次数
 *
 * 空间换时间
 *
 * 负数计算方式
 *
 *
 * @author: nj
 * @date: 2020-05-31 11:04
 * @version: 0.0.1
 */
public class RadixSort {

    public static void sort(int[] arr){

        int max = arr[0];
        for(int a : arr){
            max = Math.max(max, a);
        }

        int len = String.valueOf(max).length();

        /**
         * 存放排序结果数组
         */
        int[][] sortTempResult = new int[10][arr.length];
        //存放每个桶的实际数量
        int[] sortLength = new int[10];
        int numberIndex, index;
        for (int i = 0, t = 1; i < len; i++, t *= 10) {
            for(int a : arr){
                numberIndex = a / t % 10;
                sortTempResult[numberIndex][sortLength[numberIndex]++] = a;
            }
            index = 0;
            for (int j = 0; j < sortTempResult.length; j++) {
                for (int k = 0; k < sortLength[j]; k++) {
                    arr[index++] = sortTempResult[j][k];
                    sortTempResult[j][k] = 0;
                }
                sortLength[j] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {4,1,3,7,9,12,0,134,431,981,23,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));

//        int max = 100000;
//        int[] arr1 = new int[max];
//        for (int i = 0; i < max; i++) {
//            arr1[i] = (int)(Math.random()*max);
//        }
//        long t = System.currentTimeMillis();
//        sort(arr1);
//        System.out.println("耗时："+ (System.currentTimeMillis() - t) /1000 + "秒");
    }
}