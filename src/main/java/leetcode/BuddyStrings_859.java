package leetcode;

public class BuddyStrings_859 {

    /**
     * Given two strings A and B of lowercase letters, return true if
     *
     * and only if we can swap two letters in A so that the result equals B.
     *
     *
     *
     * Example 1:
     *
     * Input: A = "ab", B = "ba"
     * Output: true
     * Example 2:
     *
     * Input: A = "ab", B = "ab"
     * Output: false
     * Example 3:
     *
     * Input: A = "aa", B = "aa"
     * Output: true
     * Example 4:
     *
     * Input: A = "aaaaaaabc", B = "aaaaaaacb"
     * Output: true
     * Example 5:
     *
     * Input: A = "", B = "aa"
     * Output: false
     *
     *
     * Note:
     *
     * 0 <= A.length <= 20000
     * 0 <= B.length <= 20000
     * A and B consist only of lowercase letters.
     */


    public static boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        boolean flag = false, sameFlag = false;
        int k, n = -1;
        for(int i = 0; i < A.length(); i++){
            if( i != n && A.charAt(i) != B.charAt(i)){
                if(flag){
                   return false;
                }
                //judge two factors
                k = i + 1;
                while ( k < A.length()){
                    if( A.charAt(i) == B.charAt(k) && B.charAt(i) == A.charAt(k)){
                        n = k;
                        flag = true;
                        break;
                    }
                    k++;
                }
                if(!flag){
                    return false;
                }
            }else{
                //判断abcaa
                if(!sameFlag){
                    k = i + 1;
                    while (k < A.length()){
                        if( A.charAt(i) == A.charAt(k)){
                            sameFlag = true;
                            break;
                        }
                        k++;
                    }
                }

            }
        }
        return sameFlag || flag;
    }

    public static void main(String[] args) {

        System.out.println(buddyStrings("ab","ba"));
        System.out.println(buddyStrings("ab","ab"));
        System.out.println(buddyStrings("aa","aa"));
        System.out.println(buddyStrings("aaaaaaabc","aaaaaaabc"));
        System.out.println(buddyStrings("","aa"));
        System.out.println(buddyStrings("abavc","abvac"));
        //一组相同的a
        System.out.println(buddyStrings("abab","abab"));
        System.out.println(buddyStrings("acccccb","bccccca"));

    }
}
