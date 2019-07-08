package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards_914 {

    /**
     *
     * Return true if and only if you can choose X >= 2
     *
     * such that it is possible to split the entire deck into 1 or more groups of cards, where:
     *
     * Each group has exactly X cards.
     * All the cards in each group have the same integer.
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,4,4,3,2,1]
     * Output: true
     * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
     *
     *
     *
     *   1 <= deck.length <= 10000
     *   0 <= deck[i] < 10000
     */


    public static boolean hasGroupsSizeX(int[] deck) {
        //static num
        int [] numArr = new int[10000];
        for(int i = 0; i < deck.length; i++){
            numArr[deck[i]] += 1;
        }
        //sort by num
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numArr.length; i++){
            if(numArr[i] == 1){
                return false;
            }else if(numArr[i] >= 2){
                list.add(numArr[i]);
            }
        }


        boolean flag;
        for(int x = 2; x <= list.get(list.size() - 1); x ++){
            flag = true;
            for(int i : list){
                if(i % x != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,4,3,2,1};
        System.out.println(DeckOfCards_914.hasGroupsSizeX(arr1));
        int[] arr2 = {1,1,1,2};
        System.out.println(DeckOfCards_914.hasGroupsSizeX(arr2));
        int[] arr3 = {1,1,1,2,2,2,3,3};
        System.out.println(DeckOfCards_914.hasGroupsSizeX(arr3));
        int[] arr4 = {1,1,2,2,2,2};
        System.out.println(DeckOfCards_914.hasGroupsSizeX(arr4));



    }

}
