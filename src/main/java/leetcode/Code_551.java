package leetcode;

/**
 * @author: nj
 * @date: 2020-04-12 15:12
 * @version: 0.0.1
 */
public class Code_551 {

    /**
     * You are given a string representing an attendance record for a student. The record only contains the following three
     * characters:
     * 'A' : Absent.
     * 'L' : Late.
     * 'P' : Present.
     * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than
     * two continuous 'L' (late).
     *
     * You need to return whether the student could be rewarded according to his attendance record.
     *
     * Example 1:
     * Input: "PPALLP"
     * Output: True
     * Example 2:
     * Input: "PPALLL"
     * Output: False
     *
     *
     * count A <= 0
     * or continuous 'L'
     *
     */
    public static boolean checkRecord(String s) {

        int countA = 0,countL = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == 'A') {
                countA++;
                if(countA > 1){
                    return false;
                }
            }else if(c == 'L'){
                countL ++;
                while (i + 1 < s.length()){
                    if(s.charAt(i + 1) == 'L'){
                        countL ++;
                    }else{
                        break;
                    }
                    i++;
                }
                if(countL > 2){
                    return false;
                }else{
                    countL = 0;
                }
            }
        }
        return true;
    }

    /**
     *
     *
     * 正则表达式，如何工作
     *
     *
     */
    public boolean checkRecord1(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

    public static void main(String[] args) {


        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
        System.out.println(checkRecord("AA"));
    }



}