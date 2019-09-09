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
}
