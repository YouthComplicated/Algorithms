package leetcode;

/**
 * @author: nj
 * @date: 2020-03-26 20:38
 * @version: 0.0.1
 */
public class Code_434 {

    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous
     * sequence of non-space characters.
     *
     * Please note that the string does not contain any non-printable characters.
     *
     * Example:
     *
     * Input: "Hello, my   name is John"
     * Output: 5
     *
     *
     *
     * 栽树问题，选取不同的对象 会导致不同代码
     *
     * 选择空格计数，
     */

    public static int countSegments(String s) {
        if(s == null){
            return 0;
        }
        int res = 0, i = 0;
        for ( ; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                while( i+1 < s.length() && s.charAt(i+1) == 32){
                    i++;
                }
                res += 1;
            }
        }
        int front = s.charAt(0);
        int rear = s.charAt(--i);
        if(front == 32 && rear == 32){
            return res - 1;
        }else if(front != 32 && rear != 32){
            return res + 1;
        }else{
            return res;
        }

    }

    /**
     * 选择字母计数
     * @param s
     * @return
     */
    public static int countSegments1(String s){
        int segs = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i]!=' '){
                segs++;
            }
            while(i<chars.length && chars[i]!=' ') {
                i++;
            }
        }
        return segs;
    }


    public static void main(String[] args) {

        System.out.println(countSegments1("Hello, my   name is John"));
        System.out.println(countSegments1(" Hello, my   na  me is John  "));
        System.out.println(countSegments1(" Hello, a b"));
        System.out.println(countSegments1("  "));

    }


}