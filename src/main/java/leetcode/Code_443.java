package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-26 21:24
 * @version: 0.0.1
 */
public class Code_443 {

    /**
     *
     *
     * Given an array of characters, compress it in-place.
     *
     * The length after compression must always be smaller than or equal to the original array.
     *
     * Every element of the array should be a character (not int) of length 1.
     *
     * After you are done modifying the input array in-place, return the new length of the array.
     *
     *
     * Follow up:
     * Could you solve it using only O(1) extra space?
     *
     *
     * Example 1:
     *
     * Input:
     * ['a','a','b','b','c','c','c']
     *
     * Output:
     * Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
     *
     * Explanation:
     * 'aa' is replaced by 'a2'. 'bb' is replaced by 'b2'. 'ccc' is replaced by 'c3'.
     *
     *
     * a     1
     * a2    2
     * a9    2
     * a10   3
     * a99   3
     * a100  4
     *
     *
     * 有些思路是可以出结果，比如穷解答，或者过度还原整个过程(维护相当多的变量，大量的if/else 控制相当多的情况)
     * 不如换一种思路去思考，虽然能够得出答案，但对于思维训练来说，耗费太多时间，不如将这些调试各种分支情况以及
     * 理清楚相当多的状态所花费的时间，放在思考另一种思路上。这样有利于你思维的宽度。
     *
     * 下面解法未完成原因
     *
     * 1、维护太多的变量
     *
     * 2、太多的条件判断(情况)
     *
     * 3、边界问题处理的不好 循环数组比较是否相同，尽量少用 a[i+1] = a[i] 这样边界处理稍有问题
      */

    public static int compress(char[] chars) {
        if(chars == null || chars.length == 0){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }
        int result = 0, index = 1, k = 0;
        String str;
        int len = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            index = 1;
            len ++;
            if(chars[i + 1] == chars[i]){
                 k = i+1;
                while (i+1 < chars.length && chars[i + 1] == chars[i]){
                    index++;
                    i++;
                }
                if(index > 1) {
                    str = String.valueOf(index);
                    for (int j = 0; j < str.length(); j++) {
                        chars[k++] = str.charAt(j);
                        len++;
                    }
                }
            }
            result += index == 1 ? 1 : String.valueOf(index).length()+1;
        }
        System.out.println("len:"+len);

        if(index == 1){
            chars = Arrays.copyOf(chars, len - 1);
            result ++;
        }else{
            chars = Arrays.copyOf(chars, len);
        }
        System.out.println(Arrays.toString(chars));
        return result;
    }

    /**
     * 该方法思路与上面自己写的思路类似
     * 区别：
     *
     * 过度依赖 a[i+1] = a[i] 判断重复的字母数量 会导致边界问题
     *
     * 首次比较自己与自己比较(i = 0)，多了这个多余操作，但程序整体上边界问题解决
     *
     *
     * @param chars
     * @return
     */
    public static int compress1(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }


    public static void main(String[] args) {
        char[] a = {'a','a','b','b','c','c','c'};
        System.out.println(compress(a));

        char[] b = {'a'};
//        System.out.println(compress(b));

        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(c));

        char[] d = {'a','b','a','c'};
        System.out.println(compress(d));

        char[] f = {'a','b'};
        System.out.println(compress(f));


    }
}