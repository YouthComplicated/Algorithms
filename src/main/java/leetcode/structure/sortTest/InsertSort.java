package leetcode.structure.sortTest;

import java.util.Arrays;

/**
 *
 *
 * 插入排序，保证前i个数有序，i+1 放入到前面i个数中
 *
 * 10条数据耗时 1s
 *
 * @author: nj
 * @date: 2020-05-17 17:48
 * @version: 0.0.1
 */
public class InsertSort {


    /**
     *
     * 原始思路是先找到插入的位置，然后在移动数组分了两步骤
     * 实际这两步可以整合为一步就可以了
     *
     * @param arr
     */
    public static void sort1(int[] arr){
        int index = 0, temp;
        boolean flag;
        for (int i = 1; i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j]){
                    index = j;
                    flag = true;
                    break;
                }
            }
            //数组往后移动
            if(flag){
                temp = arr[i];
                int  t = i;
                while (t > index){
                    arr[t] = arr[t - 1];
                    t--;
                }
                arr[index] = temp;
            }
        }
    }


    public static void sort(int[] arr){
        int insertVal, insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex + 1] = insertVal;
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