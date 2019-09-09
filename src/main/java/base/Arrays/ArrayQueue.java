package base.Arrays;

import base.List.Queue;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFrist();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail ");
        return res.toString();
    }

    public static interface Statck<E> {

        //push
        void push(E e);

        //pop
        E pop();

        //peek
        E peek();

        //getSize
        int getSize();

        //isEmpty
        boolean isEmpty();

    }
}
