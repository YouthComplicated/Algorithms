package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-05-24 17:27
 * @version: 0.0.1
 */
public class MergeSort {



    public static void mergeSort(int arr[], int left, int right, int[] temp){

        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1 , right, temp);
            merge(arr, left, mid,right, temp);
        }

    }


    /**
     * 将两个有序数组进行合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t++] = arr[i];
                i++;
            }else{
                temp[t++]  = arr[j];
                j++;
            }
        }

        //剩余数组拷贝
        while (i <= mid){
            temp[t++] = arr[i++];
        }

        while (j <= right){
            temp[t++] = arr[j++];
        }

        //将temp拷贝到原始数组中去
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft++] = temp[t++];
        }

    }

    public static void main(String[] args) {

        int[] arr = {4,1,3,7,9,12,0,1};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

        int max = 10000000;
        int[] arr1 = new int[max];
        for (int i = 0; i < max; i++) {
            arr1[i] = (int)(Math.random()*max);
        }
        long t = System.currentTimeMillis();
        int[] temp1 = new int[arr1.length];
        mergeSort(arr1,0, temp1.length - 1, temp1);
        System.out.println("耗时："+ (System.currentTimeMillis() - t) + "毫秒");
    }



}