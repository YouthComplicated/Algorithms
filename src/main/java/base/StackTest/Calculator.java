package base.StackTest;

import java.util.Stack;

/**
 * @author: nj
 * @date: 2020-05-12 16:46
 * @version: 0.0.1
 */
public class Calculator {


    public static void main(String[] args) {

        Stack<String> ops = new Stack<>();
        Stack<Double> nums = new Stack<>();

        String str = "(1+((3-(3/3))*4))";
        char[] chars = str.toCharArray();

        char s;
        boolean isDigit;
        for (int i = 0; i < chars.length; i++) {
            s = chars[i];
            if(s == ' ' || s == '('){
                continue;
            }
            isDigit = Character.isDigit(s);
            //is digit
            if(isDigit){
                nums.push(Double.parseDouble(String.valueOf(s)));
            }else if(s != ')'){
                ops.push(String.valueOf(s));
            }else if(s == ')'){
                String op = ops.pop();
                Double a = nums.pop();
                switch (op){
                    case "-" : nums.push(nums.pop() - a);
                      break;
                    case "+" : nums.push(nums.pop() + a);
                        break;
                    case "*" : nums.push(nums.pop() * a);
                        break;
                    case "/" : nums.push(nums.pop() / a);
                        break;
                }
            }
        }

        System.out.println("计算结果是：" + nums.pop());



    }


}