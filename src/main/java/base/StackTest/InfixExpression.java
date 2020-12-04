package base.StackTest;

import antlr.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 前缀、中缀、后缀表达式
 *
 * @author: nj
 * @date: 2020-05-12 21:12
 * @version: 0.0.1
 */
public class InfixExpression {


    /**
     * 中缀==》后缀
     * @param args
     */
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        Stack<String> opsStack = new Stack<>();

        String str = "1+(5-4/2)*5-6";

        String s;
        for (int i = 0; i < str.length(); i++) {
            s = String.valueOf(str.charAt(i));
            if(Character.isDigit(s.charAt(0))){
                list.add(s);
            }else{
                if("(".equals(s)){
                    opsStack.push(s);
                }else if(")".equals(s)){
                    while (! opsStack.peek().equals("(")){
                        list.add(opsStack.pop());
                    }
                    opsStack.pop(); //弹出 "("
                }else{
                    /**
                     * 处理优先级的问题
                     */
                    while (opsStack.size() != 0 && getOpsAuth(s) < getOpsAuth(opsStack.peek())){
                        list.add(opsStack.pop());
                    }
                    opsStack.push(s);

                }
            }
        }

        while (!opsStack.isEmpty()){
            list.add(opsStack.pop());
        }



        System.out.println(list.toString());

        System.out.println("计算结果为："+calculator(list));



    }


    public static int getOpsAuth(String ops){
        int auth1 = -1;
        if(ops.equals("*") || ops.equals("/")){
            auth1 = 1;
        }else if(ops.equals("(") || ops.equals(")")){
            auth1 = -1;
        }else{
            auth1 = 0;
        }
        return auth1;

    }

    /**
     *
     * 后缀表达式计算
     *
     * [1, 5, 4, 2, /, -, 5, *, 6, -, +]
     *
     */
    public static double calculator(List<String> list){

        Stack<Double> stack = new Stack<>();

        for(String str : list){
            if(isNumber(str)){
                stack.push(Double.parseDouble(str));
            }else{
                double b = stack.pop(), a = stack.pop();
                stack.push(calc(str, a, b));
            }
        }
        return stack.pop();

    }

    /**
     * 是否为数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str){

        if(Pattern.matches("\\d+", str)){
            return true;
        }
        return false;

    }


    public static double calc(String str, double a, double b){
        double res;
        switch (str){
            case "-":
                res = a - b;
                break;
            case "/":
                res = a / b;
                break;
            case "*":
                res = a * b;
                break;
            case "+":
                res = a + b;
                break;
            default:
                throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return res;
    }




}