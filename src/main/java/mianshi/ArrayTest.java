package mianshi;

import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-10-23 22:48
 * @version: 0.0.1
 */
public class ArrayTest {


    public static void main(String[] args) {
        Node[] arr1 = new Node[1];
        Node[] arr2 = new Node[1];
        Node node1  = new Node(1);
        Node node2  = new Node(2);
        node1.next = node2;

        arr1[0] = node1;
        arr2[0] = node1;

        new Thread(()->{
            arr1[0].next = null;
            System.out.println("线程1");
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            try {
//                Thread.currentThread().wait(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
        }).start();

        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("线程2"+arr2[0].next.val);
        }).start();




//        arr1[0].next = null;


    }
}


class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}