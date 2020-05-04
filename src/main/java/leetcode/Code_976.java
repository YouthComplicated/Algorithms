package leetcode;

/**
 * @author: nj
 * @date: 2020-05-04 20:10
 * @version: 0.0.1
 */
public class Code_976 {

    /**
     *
     * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area,
     * formed from 3 of these lengths.
     *
     * If it is impossible to form any triangle of non-zero area, return 0.
     *
     * Example 1:
     *
     * Input: [2,1,2]
     * Output: 5
     * Example 2:
     *
     * Input: [1,2,1]
     * Output: 0
     * Example 3:
     *
     * Input: [3,2,3,4]
     * Output: 10
     * Example 4:
     *
     * Input: [3,6,2,3]
     * Output: 8
     *
     * Note:
     *
     * 3 <= A.length <= 10000
     * 1 <= A[i] <= 10^6
     *
     * 判断是否为三角形的条件
     *
     * 任意两边之和大于第三边
     *
     * 下面算法超时
     *
     */
    public static int largestPerimeter(int[] A) {

        int a, b, c, max = 0;
        for (int i = 0; i < A.length - 2; i++) {
            a = A[i];
            for (int j = i + 1; j < A.length - 1; j++) {
                b = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    c = A[k];
                    if(a + b > c && a + c > b && b + c > a){
                        max = Math.max(max, a+b+c);
                    }

                }
            }
        }
        return max;

    }


    public int largestPerimeter1(int[] A) {
        moveMax(A, A.length-1);
        moveMax(A, A.length-2);
        moveMax(A, A.length-3);
        for(int i=A.length-1;i>=2;i--){
            if(A[i-2]+A[i-1] > A[i]){
                return A[i-2]+A[i-1] + A[i];
            } else if(i>2) {
                moveMax(A,i-3);
            }
        }
        return 0;
    }
    public void moveMax(int[] A, int maxIndex){
        int max1 = Integer.MIN_VALUE;
        int max1Index = -1;
        for(int i=0;i<=maxIndex;i++){
            if(A[i]>max1){
                max1Index=i;
                max1=A[i];
            }
        }
        int tmp = A[maxIndex];
        A[maxIndex] = max1;
        A[max1Index] = tmp;
    }

    public static void main(String[] args) {

        int[] A1 = {2,1,2};
        System.out.println(largestPerimeter(A1));

        int[] A2 = {1,2,1};
        System.out.println(largestPerimeter(A2));

        int[] A3 = {3,2,3,4};
        System.out.println(largestPerimeter(A3));


        int[] A4 = {3,6,2,3};
        System.out.println(largestPerimeter(A4));

    }


}