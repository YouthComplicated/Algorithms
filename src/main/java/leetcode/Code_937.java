package leetcode;

import base.Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-05-03 15:30
 * @version: 0.0.1
 */
public class Code_937 {

    /**
     *
     *
     * You have an array of logs.  Each log is a space delimited string of words.
     *
     * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
     *
     * Each word after the identifier will consist only of lowercase letters, or;
     * Each word after the identifier will consist only of digits.
     * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that
     * each log has at least one word after its identifier.
     *
     * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs
     * are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs
     * should be put in their original order.
     *
     * Return the final order of the logs.
     *
     * Example 1:
     *
     * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     *
     * Constraints:
     *
     * 0 <= logs.length <= 100
     * 3 <= logs[i].length <= 100
     * logs[i] is guaranteed to have an identifier, and a word after the identifier.
     *
     *
     * 1、按照规则进行分组
     * 2、分组之后的排序  字母类型日志按照字符顺序排列， 数字类型的日志按照原顺序排列
     *
     */

    public static String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        int i = 0, j = logs.length - 1;
        for (String log : logs) {
            int index = log.indexOf(" ");
            String str = log.substring(index + 1, log.indexOf(" ", index + 1));
            if(Character.isLetter(str.charAt(0))){
                //排序order
                ans[i++] = log;
            }else{
                ans[j--] = log;
            }
        }

        List<String> ret = new ArrayList<>();
        //sort letter group
        doubleSort(ans, i);
        //reverse dig
        int start = j + 1, end = ans.length - 1;
        String temp;
        while (start < end){
            temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start ++;
            end --;
        }

        return  ans;
    }

    /**
     * 冒泡排序
     */
    public static void doubleSort(String[] arr, int t){
        String str1, str2, regexStr1, regexStr2;
        int index1, index2;
        for(int i = 0; i < t - 1 ; i++){
            for (int j = 0; j < t - i - 1; j++) {
                str1 = arr[j]; str2 = arr[j + 1];
                index1 = str1.indexOf(" ");index2 = str2.indexOf(" ");
                regexStr1 = str1.substring(index1 + 1, str1.indexOf(" ", index1 + 1));
                regexStr2 = str2.substring(index2 + 1, str2.indexOf(" ", index2 + 1));
                System.out.println("str1:" + regexStr1+" str2:" + regexStr2);
                if(regexStr1.compareTo(regexStr2) > 0){
                    String temp = str1;
                    arr[j] = str2;
                    arr[j+1] = temp;
                }
            }
        }
    }


    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {

        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));

        System.out.println(Arrays.toString(logs[0].split(" ", 2)));

    }


}