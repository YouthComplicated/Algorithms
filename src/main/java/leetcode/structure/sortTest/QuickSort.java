package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 * 思想接近二分法，递归到元素等于1
 *
 * @author: nj
 * @date: 2020-05-24 16:21
 * @version: 0.0.1
 */
public class QuickSort {


    /**
     *
     * 左右两边的不对称性
     *
     *
     *
     */
    public static void quickSort(int [] arr , int left, int right){
        int l = left, r = right;
        int pivot = arr[ (left + right) / 2 ];
        int temp;
        while (l < r){
            //左边从第一个数进行寻找，找到大于的数然后退出
            while (arr[l] < pivot){
                l++;
            }

            while (arr[r] > pivot){
                r--;
            }

            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //左边
            if(arr[l] == pivot){
                r -= 1;
            }

            if(arr[r] == pivot){
                l += 1;
            }
        }

        if(l == r){
            l += 1;
            r -= 1;
        }

        if(left < r){
            quickSort(arr, left, r);
        }

        if(right > l){
            quickSort(arr, l, right);
        }



    }

    public static void main(String[] args) {

        int [] arr = {12,11,9,1,4,3,2};
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


        int max = 10000000;
        int[] arr1 = new int[max];
        for (int i = 0; i < max; i++) {
            arr1[i] = (int)(Math.random()*max);
        }
        long t = System.currentTimeMillis();
        quickSort(arr1,0, arr1.length - 1);
        System.out.println("耗时："+ (System.currentTimeMillis() - t)+ "毫秒");

    }
}