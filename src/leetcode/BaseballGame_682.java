package leetcode;

public class BaseballGame_682{

    /**
     * Each round's operation is permanent and could have an impact on the round before and the round after.
     *
     * You need to return the sum of the points you could get in all the rounds.
     *
     * Example 1:
     * Input: ["5","2","C","D","+"]
     * Output: 30
     * Explanation:
     * Round 1: You could get 5 points. The sum is: 5.
     * Round 2: You could get 2 points. The sum is: 7.
     * Operation 1: The round 2's data was invalid. The sum is: 5.
     * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
     * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
     * Example 2:
     * Input: ["5","-2","4","C","D","9","+","+"]
     * Output: 27
     * Explanation:
     * Round 1: You could get 5 points. The sum is: 5.
     * Round 2: You could get -2 points. The sum is: 3.
     * Round 3: You could get 4 points. The sum is: 7.
     * Operation 1: The round 3's data is invalid. The sum is: 3.
     * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
     * Round 5: You could get 9 points. The sum is: 8.
     * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
     * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
     * Note:
     * The size of the input list will be between 1 and 1000.
     * Every integer represented in the list will be between -30000 and 30000.
     *
      */

    public static int calPoints(String[] ops) {
        /**
         * C  减去前一个值  并记录之前的两个值
         *
         * D  前一个值 * 2 然后在相加
         *
         * + 前两个数相加 在求和
         */
        int sum = 0,k=0,j=0, l= 0,q = 0;
        for(int i = 0; i < ops.length; i++){
            if("C".equals(ops[i])){
                k = i-1;
                while (true){
                    if(ops[k].matches("-?[0-9]+.*[0-9]*")){
                        sum -= Integer.parseInt(ops[k]);
                        ops[k] = "";
                        break;
                    }
                    k--;
                }
            }else if("D".equals(ops[i])){
                k = i-1;
                while (true){
                    if(ops[k].matches("-?[0-9]+.*[0-9]*")){
                        sum += Integer.parseInt(ops[k])*2;
                        ops[i] = String.valueOf(Integer.parseInt(ops[k])*2);
                        break;
                    }
                    k--;
                }
            }else if("+".equals(ops[i])){
                k = i-1;
                while (true){
                    if(ops[k].matches("-?[0-9]+.*[0-9]*")){
                        l = Integer.parseInt(ops[k]);
                        sum += l;
                        j = k-1;
                        while (true){
                            if(ops[j].matches("-?[0-9]+.*[0-9]*")){
                                q = Integer.parseInt(ops[j]);
                                sum += q;
                                break;
                            }
                            j--;
                        }
                        ops[i] = String.valueOf(l+q);
                        break;
                    }
                    k--;
                }

            }else{
                sum += Integer.parseInt(ops[i]);
            }
//            System.out.println("===="+sum);
        }

        return sum;
    }

    public static void main(String[] args) {

        String[] str1 = {"5","2","C","D","+"};
        System.out.println(calPoints(str1));
        String[] str2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(str2));

    }
}
