package jdk.collection.list;

import org.junit.Test;

import java.util.Stack;

public class TestStack {

    @Test
    public void test01(){

        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        stack.push(22);
        stack.pop();

    }

    @Test
    public void test02(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.add(2);
        System.out.println(stack.pop());
        stack.add(0,3);
        System.out.println(stack.pop());
    }
}
