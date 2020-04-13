package leetcode;

import base.Arrays.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: nj
 * @date: 2020-04-10 15:27
 * @version: 0.0.1
 */
public class Code_500 {


    /**
     *
     * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
     *
     * keyboard like the image below.
     *
     *
     *
     * Example:
     *
     * Input: ["Hello", "Alaska", "Dad", "Peace"]
     * Output: ["Alaska", "Dad"]
     *
     *
     * Note:
     *
     * You may use one character in the keyboard more than once.
     * You may assume the input string will only contain letters of alphabet.
     */

    private static int [] character = new int[26];

    static {
        char[] firstLine = {'q','w','e','r','t','y','u','i','o','p'};
        char[] secondLine = {'a','s','d','f','g','h','j','k','l'};
        char[] thirdLine = {'z','x','c','v','b','n','m'};
        for (int i = 0; i < firstLine.length; i++) {
            character[firstLine[i] - 97] = 1;
        }
        for (int i = 0; i < secondLine.length; i++) {
            character[secondLine[i] - 97] = 2;
        }
        for (int i = 0; i < thirdLine.length; i++) {
            character[thirdLine[i] - 97] = 3;
        }
    }

    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        int index1, index2;
        boolean flag;
        for(String str : words){
            flag = true;
            for (int i = 1; i < str.length(); i++) {
                index1 = Character.toLowerCase(str.charAt(i)) - 'a';
                index2 = Character.toLowerCase(str.charAt(i - 1)) - 'a';
                if(index1 >= 0 && index1 < 26
                    && index2 >= 0 && index2 < 26){
                    if(character[index1] != character[index2]){
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add(str);
            }
        }

        String [] temp = new String[result.size()];
        int i = 0;
        for (String str : result){
            temp[i++] = str;
        }
        return temp;




    }

    public String[] findWords1(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }


    public static void main(String[] args) {

        String [] str = {"Hello", "Alaska", "Dad", "Peace"};

        System.out.println(Arrays.toString(findWords(str)));



    }




}











