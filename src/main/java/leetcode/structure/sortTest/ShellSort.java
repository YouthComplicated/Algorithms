package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 * 希尔排序,简单插入排序的高效版本，也称缩小增量排序
 *
 *
 * @author: nj
 * @date: 2020-05-17 18:31
 * @version: 0.0.1
 */
public class ShellSort {


    /**
     *
     *  [1,2,3,4,5,6,7,8,9,10]
     *  space = 5 [1,6][2,8]...[5,10]
     *  space = 2 [1,3,5,7,9],[2,4,6,8,10]
     *  sapce = 1 []
     *
     *
     *
     * @param arr
     */
    public static void sort(int [] arr){

        int len = arr.length,space = len / 2;
        int insertVal, insertIndex;
        while (space > 0){
            for (int j = 0; j < space; j++) {
                for (int i = j + space; i < arr.length; i += space) {
                    insertVal = arr[i];
                    insertIndex = i - space;
                    while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                        arr[insertIndex + space] = arr[insertIndex];
                        insertIndex = insertIndex - space;
                    }
                    arr[insertIndex + space] = insertVal;
                }
//                System.out.println(Arrays.toString(arr));
            }
            space = space / 2;
        }

    }

    /**
     * 交换排序
     * @param arr
     */
    public static void sort1(int [] arr){
        int space = arr.length / 2;
        int temp;
        while (space > 0){
            for (int i = space; i < arr.length; i++) {
                for (int j = i - space; j >= 0; j -= space) {
                    if(arr[j] > arr[j + space]){
                        temp = arr[j];
                        arr[j] = arr[j + space];
                        arr[j + space] = temp;
                    }
                }
            }
            space = space / 2;
        }

    }

    /**
     * 移位排序
     * @param arr
     */
    public static void sort2(int [] arr){
        int space = arr.length / 2;
        int insertVal, insertIndex;
        for ( ; space > 0; space /= 2) {
            for (int i = space; i < arr.length; i++) {
                insertIndex = i;
                insertVal = arr[i];
                if(arr[insertIndex] < arr[insertIndex - space]){
                    while (insertIndex - space >= 0 && insertVal < arr[insertIndex - space]){
                        arr[insertIndex] = arr[insertIndex - space];
                        insertIndex -= space;
                    }
                    arr[insertIndex] = insertVal;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {4,1,3,7,9,12,0,1};
        sort1(arr);
//        System.out.println(Arrays.toString(arr));

        int max = 10000000;
        int[] arr1 = new int[max];
        for (int i = 0; i < max; i++) {
            arr1[i] = (int)(Math.random()*max);
        }
        long t = System.currentTimeMillis();
        sort2(arr1);
        System.out.println("耗时："+ (System.currentTimeMillis() - t) + "毫秒");
    }
}