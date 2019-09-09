package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutermostParentheses_1021 {

    /**
     * 没有必要使用stack去匹配括号，最终还是根据stack.size() = 1 和 = 0 判断来拼串
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        List<Integer> resultIndex = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < chars.length; i ++ ){
            if(!stack.isEmpty()){
                if(chars[i] == ')'){
                    if(stack.peek() == '(' && stack.size() > 1 ){
                        resultIndex.add(i);
                        stack.pop();
                    }else{
                        stack.pop();
                    }
                }else{
                    stack.push(chars[i]);
                    resultIndex.add(i);
                }
            }else{
                stack.push(chars[i]);
            }
        }

        for(Integer index : resultIndex){
            sb.append(chars[index]);
        }
        return sb.toString();
    }
    public String removeOuterParentheses1(String S) {
        StringBuilder answer = new StringBuilder();
        char[] arr = S.toCharArray();

        int valid = 0;
        for (char ch : arr) {
            if (ch == '(' && valid++ > 0) answer.append(ch);
            if (ch == ')' && valid-- > 1) answer.append(ch);
        }
        return answer.toString();
    }

    public static void main(String[] args) {

        RemoveOutermostParentheses_1021 instance = new RemoveOutermostParentheses_1021();
        System.out.println(instance.removeOuterParentheses("(()())(())"));
        System.out.println(instance.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(instance.removeOuterParentheses("()()"));


    }
}
