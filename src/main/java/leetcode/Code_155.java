package leetcode;

import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-08 20:29
 * @version: 0.0.1
 */
public class Code_155 {

    /**
     * Design a stack that supports push, pop, top, and retrieving
     * the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     *
     * Example:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     */


    public static void main(String[] args) {

        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */

//        MinStack obj = new MinStack();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        System.out.println(obj.getMin());
//        obj.pop();
//        System.out.println(obj.top());
//        System.out.println(obj.getMin());


        /**
         * ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
         * [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
         */

        MinStack minStack = new MinStack();
//        minStack.push(-10);
//        minStack.push(-14);
//        System.out.println(minStack.getMin());
//        System.out.println(minStack.getMin());
//        minStack.push(-20);
//        System.out.println(minStack.getMin());
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        minStack.push(10);
//        minStack.push(-7);
//        System.out.println(minStack.getMin());
//        minStack.push(-7);

//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(3);
//        minStack.push(4);
//        minStack.push(5);
//        minStack.push(6);
//        minStack.pop();
//        minStack.pop();
//        minStack.pop();
//        minStack.pop();
//        minStack.pop();
//        minStack.pop();


        /**
         * ["MinStack","push","push","top","getMin","pop","getMin","top"]
         * [[],[1],[2],[],[],[],[],[]]
         * Output
         * [null,null,null,2,0,null,0,1]
         * Expected
         * [null,null,null,2,1,null,1,1]
         */

        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
//        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        minStack.top();
    }





}

class MinStack {

    int [] data;
    int min, index = -1;
    int size;

    /** initialize your data structure here. */
    public MinStack() {
        size = 2;
        data = new int[2];
    }

    public void push(int x) {
        index ++;
        if(index > size - 1){
            expandSize();
        }
        data[index] = x;
        if(index == 0){
            min = x;
            return;
        }
        if(x < min){
            min = x;
            return;
        }

    }

    public void pop() {
        if(min == data[index]){
            int k = index - 1;
            if(k < 0){
                return ;
            }else if(k >= 1){
                min = data[k];
                for(int i = 1; i <= k; i++){
                    if(min > data[i]){
                        min = data[i];
                    }
                }
            }

        }
        data[index] = 0;
        index --;
//        if(index < size - size/2){
//            reduceSize();
//        }
    }

    public int top() {
        return  data[index];
    }

    public int getMin() {
        return min;
    }

    private void expandSize(){
        int newSize = size + size/2;
        data = Arrays.copyOf(data, newSize);
        size = newSize;
    }

    private void reduceSize(){
        int newSize = size - size/2;
        data = Arrays.copyOf(data, newSize);
        size = newSize;
    }
}