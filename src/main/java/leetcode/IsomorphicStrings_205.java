package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     * Output: true
     *
     */


    /**
     * 使用两个map,双向数据查找
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        if("".equals(s) && "".equals(t)){
            return true;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character,Integer> sourceMap = new HashMap<>();
        Map<Character,Integer> targetMap = new HashMap<>();
        sourceMap.put(sArr[0],0);
        targetMap.put(tArr[0],0);
        Integer sourceIndex, targetIndex;
        for(int i = 1; i < sArr.length; i++){
            if((sourceIndex = sourceMap.get(sArr[i])) == null){
                if((targetIndex = targetMap.get(tArr[i])) == null){
                    sourceMap.put(sArr[i],i);
                    targetMap.put(tArr[i],i);
                }else{
                    if(sArr[i] != sArr[targetIndex]){
                        return false;
                    }
                }
            }else{
                if(tArr[i] != tArr[sourceIndex]){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 利用数组做字典，下标和元素对应,并且不是完全匹配
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic1(String s, String t) {

        char[] sar=s.toCharArray();
        char[] tar=t.toCharArray();

        char[] a= new char[256];
        char[] b= new char[256];

        for(int i=0;i<sar.length;i++){
            char x=sar[i];
            char y=tar[i];

            if(a[x]==0 && b[y]==0){
                a[x]=y;
                b[y]=x;
            }
            else if(a[x] !=y ||b[y] !=x){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsomorphicStrings_205.isIsomorphic("egg","add"));
        System.out.println(IsomorphicStrings_205.isIsomorphic("foo","bar"));
        System.out.println(IsomorphicStrings_205.isIsomorphic("paper","title"));
        System.out.println(IsomorphicStrings_205.isIsomorphic("ab","aa"));

    }
}
