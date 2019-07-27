package leetcode;

public class ExcelSheetColumnNumber_171 {

    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     *
     * For example:
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * Example 1:
     *
     * Input: "A"
     * Output: 1
     * Example 2:
     *
     * Input: "AB"
     * Output: 28
     * Example 3:
     *
     * Input: "ZY"
     * Output: 701
     */


    /**
     * 进制的问题 26机制
     * @param s
     * @return
     */
    public  static int titleToNumber(String s) {
        int result = 0;
        int pow = 1;
        for(int i = s.length() -1; i >= 0; i--){
            result += (s.charAt(i) - 64) * pow;
            pow *= 26;
        }
        return  result;
    }




    public static void main(String[] args) {
        char a = 'A';
        System.out.println((int)a);

        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));

    }


}
