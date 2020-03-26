package leetcode;

/**
 * @author: nj
 * @date: 2020-03-08 16:05
 * @version: 0.0.1
 */
public class Code_125 {


    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     */


    public static  boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        boolean prx, sub;
        boolean result = true;
        char a, b;
        while (i < j){
             a  = chars[i];
             b  = chars[j];
             prx = Character.isLetterOrDigit(a);
             sub = Character.isLetterOrDigit(b);
             if(prx && sub){
                 if(Character.toUpperCase(a) != Character.toUpperCase(b)){
                     result = false;
                     break;
                 }
                 i++;
                 j--;
             }else if(prx && !sub){
                 j--;
             }else if(!prx && sub){
                 i++;
             }else{
                 i++;
                 j--;
             }
        }
        return result;

    }


    public boolean isPalindrome1(String s) {
        if(s==null) return false;
        if(s.length()<2) return true;
        for(int i=0,j=s.length()-1;i<=j;){
            char temp1 = s.charAt(i),temp2 = s.charAt(j);
            if(temp1>64&&temp1<91) temp1=(char)(temp1+32);
            if(temp2>64&&temp2<91) temp2=(char)(temp2+32);
            if((temp1<97&&temp1>57)||temp1>122||temp1<48) {
                i++;
                continue;
            }
            if((temp2<97&&temp2>57)||temp2>122||temp2<48){
                j--;
                continue;
            }
            if(temp1!=temp2) return false;
            i++;
            j--;
        }
        return true;
    }





    public static void main(String[] args) {
        char f = '0';
        System.out.println(Character.toUpperCase(f));


        String a = "A man, a plan, a canal: Panama";
        String b = "race a car";
        String c = "0P";
        String d = "";
        String g = ".";
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
        System.out.println(isPalindrome(d));
        System.out.println(isPalindrome(g));
    }
}