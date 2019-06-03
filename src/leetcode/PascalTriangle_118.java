package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle_118 {

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
     */


    public static void main(String[] args) {
        PascalTriangle_118 instance = new PascalTriangle_118();
        System.out.println(instance.generate(1));
        System.out.println(instance.generate(2));
        System.out.println(instance.generate(3));
        System.out.println(instance.generate(4));
        System.out.println(instance.generate(5));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows < 0 ){
            return result;
        }
        if(numRows == 1){
            result.add(Arrays.asList(1));
        }
        if(numRows >= 2){
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));
        }

        List<Integer> tempList;
        if(numRows > 2){
            for(int i = 1; i < numRows - 1; i++){
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
        return result;
    }
}