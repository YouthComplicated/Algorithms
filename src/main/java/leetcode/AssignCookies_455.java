package leetcode;

import java.util.Arrays;

public class AssignCookies_455 {

    /**
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie. Each child i has a greed factor gi,
     * which is the minimum size of a cookie that the child will be content with; and each cookie
     * j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
     * Your goal is to maximize the number of your content children and output the maximum number.
     *
     * Note:
     * You may assume the greed factor is always positive.
     * You cannot assign more than one cookie to one child.
     *
     * Example 1:
     * Input: [1,2,3], [1,1]
     *
     * Output: 1
     *
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     * Input: [1,2], [1,2,3]
     *
     * Output: 2
     *
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     */


    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0, j = 0;
        for(int i = 0; i < s.length; i++){
            for(; j < g.length; j++){
                if(s[i] >= g[j]){
                    result++;
                    j++;
                    break;
                }else{
                    break;
                }
            }
        }
        return result;
    }


    /**
     * very slowly 相对于上面的方法
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(s);
        int result = 0;
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < g.length ; j++){
                if( g[j] != -1 && s[i] >= g[j]){
                    result++;
                    g[j] = -1;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 最快 思路一样，但是排序方式采用二分排序
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        sort(g, 0, g.length-1);
        sort(s, 0, s.length-1);

        int count = 0;
        int j=0;
        for(int i=0; i<g.length; i++){
            while(j<s.length){
                if(s[j] >= g[i]){
                    count++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return count;
    }
    private static void sort(int[] number, int left, int right) {
        if(left < right) {
            int q = partition(number, left, right);
            sort(number, left, q-1);
            sort(number, q+1, right);
        }

    }

    private static int partition(int number[], int left, int right) {
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(number[j] < number[right]) {
                i++;
                swap(number, i, j);
            }
        }
        swap(number, i+1, right);
        return i+1;
    }

    private static void swap(int[] number, int i, int j) {
        int t = number[i];
        number[i] = number[j];
        number[j] = t;
    }



    public static void main(String[] args) {
//        int [] a1 = {1,2,3};
//        int [] b1 = {1,1};
//        System.out.println(findContentChildren(a1,b1));
//        int [] a2 = {1,2};
//        int [] b2 = {1,2,3};
//        System.out.println(findContentChildren(a2,b2));
//        int [] a3 = {10,9,8,7};
//        int [] b3 = {5,6,7,8};
//        System.out.println(findContentChildren(a3,b3));


//        int [] a1 = {1,2,3};
//        int [] b1 = {1,1};
//        System.out.println(findContentChildren1(a1,b1));
        int [] a2 = {1,2};
        int [] b2 = {1,2,3};
        System.out.println(findContentChildren1(a2,b2));
        int [] a3 = {10,9,8,7};
        int [] b3 = {5,6,7,8};
        System.out.println(findContentChildren1(a3,b3));

    }
}
