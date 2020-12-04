package leetcode.structure.search;

/**
 *
 *
 * 二分查找法，必需有序
 *
 *
 * @author: nj
 * @date: 2020-05-31 12:07
 * @version: 0.0.1
 */
public class BinarySerach {


    /**
     * 二分查找
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int find(int [] arr, int left, int right, int findVal){
        if(left > right){
            return  -1;
        }

        int mid = (left + right) / 2;

        if(arr[mid] > findVal){
            return find(arr, left, mid - 1, findVal);
        }else if(arr[mid] < findVal){
            return find(arr, mid + 1, right, findVal);
        }else{
            return mid;
        }
    }


    /**
     * 差值查找算法
     */
    public static int insertFind(int [] arr, int left, int right, int findVal){
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return  -1;
        }

        int mid =  left + (findVal - arr[left]) / (arr[right] - arr[left]) * (right - left);

        if(arr[mid] > findVal){
            return insertFind(arr, left, mid - 1, findVal);
        }else if(arr[mid] < findVal){
            return insertFind(arr, mid + 1, right, findVal);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        System.out.println(find(arr, 0, arr.length, 2));
        System.out.println(insertFind(arr, 0, arr.length, 2));


    }

}