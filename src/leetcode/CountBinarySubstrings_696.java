package leetcode;

public class CountBinarySubstrings_696 {
    /**
     * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
     *
     * and all the 0's and all the 1's in these substrings are grouped consecutively.
     *
     * Substrings that occur multiple times are counted the number of times they occur.
     *
     * Example 1:
     * Input: "00110011"
     * Output: 6
     * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
     *
     * Notice that some of these substrings repeat and are counted the number of times they occur.
     *
     * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     * Example 2:
     * Input: "10101"
     * Output: 4
     * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
     */


    public static int countBinarySubstrings(String s) {
        int result = 0;
        if(s.length() == 1){
            return result;
        }
        boolean flag;
        int continousNum = 0, index = 0, k,j;
        char [] chars = s.toCharArray();
        for(int i = 1 ; i < chars.length; i++){
            if(chars[i] != chars[i-1]){
                 index ++;
                 result ++;
                 continousNum = 1;
            }else{
                continousNum ++;
                if(index > 0){
                    //确定该范围内是否满足
                    k = i - continousNum * 2 + 1;
                    flag = true;
                    if( k >= 0){
                        while ( k <= i - continousNum){
                            if(chars[k] == chars[i]){
                                flag = false;
                                break;
                            }
                            k++;
                        }
                        if(flag){
                            result ++;
                        }
                    }
                }
            }
        }

        return result;
    }


    public static  int countBinarySubstrings1(String s) {
        int count = 0;
        int count1 = 1;
        int count2 = 0;
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]) {
                count1++;
                if(count2 >= count1) {
                    count++;
                }
            }else{
                count++;
                count2 = count1;
                count1 = 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("1011"));

        System.out.println(countBinarySubstrings("000111000"));
        System.out.println(countBinarySubstrings("11110011"));

        System.out.println(countBinarySubstrings("1010001"));


    }


}
