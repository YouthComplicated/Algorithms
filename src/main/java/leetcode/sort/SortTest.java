package leetcode.sort;


import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-11-08 16:24
 * @version: 0.0.1
 */
public class SortTest {

    public static void main(String[] args) {

        /**
         * 1、冒泡测试
         */
        int[] arr1 = {1,6,3,9,12,5,6};
        System.out.println(Arrays.toString(bubbleSort(arr1)));

        /**
         * 2、选择排序
         *
         * 5,4,1,2,3
         * 3,4,1,2,5  第一次
         *
         */
        int[] arr2 = {5,4,1,2,3};
        System.out.println(Arrays.toString(selectSort(arr2)));


        int[] arr3 = {5,4,1,2,3};
        System.out.println(Arrays.toString(insertSort(arr3)));


        int[] arr4 = {5,4,3,1,9};
        System.out.println(Arrays.toString(shellSort(arr4)));


    }


    /**
     * 1、冒泡排序 T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2）
     *
     * 比较相邻位置，如果有变化则交换位置，每次走完，确定最后n-i最大元素
     */
    public static int[] bubbleSort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        for(int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++) {
                 if(arr[j+1] < arr[j]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
            }
        }
        return arr;
    }

    //

    /**
     *  2、选择排序       T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *
     *    5,4,1,2,3
     *    3,4,1,2,5  第一次
     *    3,2,1,4,5
     *
     *
     */
    public static int[] selectSort(int[] array){
        System.out.println("======");
//        if(arr == null || arr.length == 0){
//            return arr;
//        }
//        //n-1趟
//        int index, max;
//        for (int i = 0; i < arr.length - 1; i++) {
//            max = arr[0];
//            index = 0;
//            for (int j = 0; j < arr.length - i; j++) {
//                if(arr[j] > max){
//                    max = arr[j];
//                    index = j;
//                }
//            }
//            int temp = arr[index];
//            arr[index] = arr[arr.length - i - 1];
//            arr[arr.length - i - 1] = temp;
//        }

        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
//            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 3、插入排序 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * 5,4,1,2,3
     *
     */
    public static int[] insertSort(int[] array){
        System.out.println("=== insertSort  ===");
        if (array.length == 0)
            return array;

//        int current;
//        for (int i = 1; i < array.length; i++) {
//            //如果小于则进行插入
//            int index = i;
//            for (int j = i - 1; j >= 0; j--) {
//                if(array[index] < array[j]){
//                    int temp = array[j];
//                    array[j] = array[index];
//                    array[index] = temp;
//                    index -- ;
//                }else{
//                    break;
//                }
//            }
//            System.out.println(Arrays.toString(array));
//
//        }

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;


    }

    /**
     *
     * 4、希尔排序
     *
     *  分组然后逐步扩大组的间距
     *
     * 最佳情况：T(n) = O(nlog2 n)
     * 最坏情况：T(n) = O(nlog2 n)
     * 平均情况：T(n) =O(nlog2n)
     *
     */
    public static int[] shellSort(int[] array){
        System.out.println("=== shellSort  ===");
        if (array.length == 0 || array.length == 1)
            return array;

//        int space = array.length / 2;
//        int index, current;
//        while (space >= 1){
//            for (int i = 0; i < array.length - space; i ++) {
//                current = array[i + space];
//                index = i;
//                while (index >= 0 && array[index] > current){
//                    array[index + space] = array[index];
//                    index -= space;
//                }
//                array[index + space] = current;
//            }
//            System.out.println(Arrays.toString(array));
//            space = space / 2;
//        }
//
//        return array;


        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            //此处i = gap
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;


    }


    /**
     *
     * 归并排序 分治法
     *
     * 递归出口 mid = array.length / 2;
     *
     * 归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     *
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }



    /**
     *
     * 快速排序方法
     *
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end){
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        //随机的找一个
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public static int partition1(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right){
            while (left < right && array[right] > temp){
                right--;
            }
            if(left < right){
                array[left] = array[right];
                left++;
            }
            while (left < right && array[left] < temp){
                left --;
            }
            if(left < right){
                array[right] = array[left];
                right --;
            }
        }
        array[left] = temp;
        return left;
    }


    public static int[] QuickSort1(int[] array, int left, int right) {
        if (array == null || left >= right || array.length <= 1) {
            return array;
        }

        int mid = partition1(array, left, right);

        QuickSort1(array, left, mid);
        QuickSort1(array, mid+1, right);

        return array;
    }




    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }









}