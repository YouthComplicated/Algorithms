package base.List;

import base.Arrays.ArrayQueue;

public class LinkListStack<E> implements ArrayQueue.Statck<E> {

    private LinkedList<E> list;

    public LinkListStack(){
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFrist(e);
    }

    @Override
    public E pop() {
        return list.removeFrist();
    }

    @Override
    public E peek() {
        return list.getFrist();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkListStack<Integer> stack = new LinkListStack<>();
        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
