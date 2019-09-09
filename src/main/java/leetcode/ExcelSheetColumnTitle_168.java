package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetColumnTitle_168 {

    /**
     *
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     *
     * For example:
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * Example 1:
     *
     * Input: 1
     * Output: "A"
     * Example 2:
     *
     * Input: 28
     * Output: "AB"
     * Example 3:
     *
     * Input: 701
     * Output: "ZY"
     */


    public static String convertToTitle(int n) {

        List<Integer> list =new ArrayList<>();
        while (n != 0){
            list.add((n % 26));
            n /= 26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            //处理为0的情况
            if(list.get(i) == 0){
                if(i == list.size() - 1){
                    break;
                }
                sb.append('Z');
                list.set(i + 1, list.get(i + 1) - 1);
            }else{
                sb.append((char)(list.get(i)+64));
            }
        }
        return sb.reverse().toString();

    }

    public static String convertToTitle1(int n) {
        if(n < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            //n%26 存在0 0 没有对应的字母表示，所以--，保证n%26 != 0
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return new String(sb.reverse());
    }


    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2053));


    }


}
