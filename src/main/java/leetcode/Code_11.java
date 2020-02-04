package leetcode;

/**
 * @author: nj
 * @date: 2020-02-03 08:41
 * @version: 0.0.1
 */
public class Code_11 {
    /**
     *
     *
     *
     *
     */

    /**
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0,temp;
        for(int i = 0; i < height.length - 1; i++){
            for(int k = i + 1; k < height.length; k++){
                if(height[i] < height[k]){
                    temp = height[i] * (k-i);
                }else{
                    temp = height[k] * (k-i);
                }
                if(temp > max){
                    max = temp;
                }
            }
        }

        return max;


    }

    public static int maxArea1(int[] height) {
        int max_area = 0;
        for (int i=0, j=height.length-1; i < j;) {
            max_area = Math.max((j - i) * Math.min(height[i], height[j]), max_area);
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max_area;

    }




    public static void main(String[] args) {
        int [] arr = {1,8,6,2,5,4,8,3,7};
        int [] arr1 = {1};
        System.out.println(maxArea(arr));
        System.out.println(maxArea(arr1));
    }
}










