package leetcode;

import base.Arrays.Array;

import java.util.Arrays;
import java.util.List;

public class AddStrings_415 {


    /**
     * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
     *
     * Note:
     *
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */


    public static String addStrings(String num1, String num2) {
        int num3 = 0;
        String  [] num1Arr= num1.split("");
        String  [] num2Arr= num2.split("");
        int i = num1Arr.length - 1, j = num2Arr.length - 1;

        int k = 1;
        while (true){
            if( i >= 0){
               num3 += Integer.parseInt(num1Arr[i])*k;
               i--;
            }
            if( j >= 0){
                num3 += Integer.parseInt(num2Arr[j])*k;
                j--;
            }
            if(i < 0 && j < 0){
                break;
            }
            k*=10;
        }
        return String.valueOf(num3);
    }

    public static String addStrings1(String num1, String num2) {
        int num3, k = 0;
        char  [] num1Arr= num1.toCharArray();
        char  [] num2Arr= num2.toCharArray();
        int i = num1Arr.length - 1, j = num2Arr.length - 1;
        int[] result = new int[i >= j ? i+2 : j + 2];
        int temp = 0;
        while (true){
            num3 = 0;
            if( i >= 0){
                num3 += ((int)num1Arr[i] - 48);
                i--;
            }
            if( j >= 0){
                num3 += ((int)num2Arr[j] - 48);
                j--;
            }
            num3 += temp;
            result[k++] = num3 % 10;
            temp = num3 >= 10 ? 1 : 0;
            if(i < 0 && j < 0){
                if(temp == 1){
                    result[k] = temp;
                }
                break;
            }
        }


        int h = result[result.length -1] == 0 ? result.length - 2 : result.length - 1;
        StringBuilder sb = new StringBuilder();
        while (h>=0){
            sb.append(result[h--]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(addStrings1("9",
                "99"));

        //"10405985147604178950"
        //"3876620623801494171"
        //"6529364523802684779"
        System.out.println(addStrings1("3876620623801494171",
                "6529364523802684779"));

        char[] chars = {'0','1','2','3','4','5','6','7','8','9'};
        System.out.println(chars[0]+1);
        System.out.println(chars[1]+1);
        System.out.println(Arrays.toString(chars));
    }


}
