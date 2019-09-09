package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle_119 {

    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     *
     * Example:
     *
     * Input: 5
     * Output:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * Example:
     *
     * Input: 3
     * Output: [1,3,3,1]
     * Follow up:
     *
     * Could you optimize your algorithm to use only O(k) extra space?
     */


    public static void main(String[] args) {
        PascalTriangle_119 instance = new PascalTriangle_119();
        System.out.println(instance.generate(0));
        System.out.println(instance.generate(1));
        System.out.println(instance.generate(2));
        System.out.println(instance.generate(3));
        System.out.println(instance.generate(4));
        System.out.println(instance.generate(5));
    }


    public List<Integer> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            result.add(Arrays.asList(1));
        }
        if(numRows >= 1){
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));
        }
        List<Integer> tempList;
        if(numRows > 1){
            for(int i = 1; i < numRows; i++){
                List<Integer> generteaList = new ArrayList<>();
                generteaList.add(1);
                tempList = result.get(i);
                for(int j = 0; j < tempList.size() - 1; j++){
                    generteaList.add(tempList.get(j) + tempList.get(j+1));
                }
                generteaList.add(1);
                result.add(generteaList);
            }
        }

        return result.get(result.size() - 1);
    }

    /**
     * 递归使用
     */
    public List<Integer> generate(int numRows) {
        List<Integer> result = new ArrayList<>();
        if(numRows == 0){
            result.add(1);
            return result;
        }else if(numRows == 1) {
            result.addAll(Arrays.asList(1, 1));
            return result;
        }else{
            List<Integer>  list =  generate(numRows - 1);
            result.add(1);
            for(int j = 0; j < list.size() - 1; j++){
                result.add(list.get(j)+list.get(j+1));
            }
            result.add(1);
            return result;
        }
    }

}