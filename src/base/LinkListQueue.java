package base;

public class LinkListQueue<E> implements Queue<E>{

    private class Node{
       public E e;
       public Node next;

       public Node(E e){
           this.e = e;
       }
       public Node(){
           this.e = null;
           this.next = null;
       }

       public Node(E e, Node node){
           this.e = e;
           this.next = node;
       }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }

    private Node head,tail;

    private int size;

    public LinkListQueue(){
        head = tail = null;
        this.size = 0;
    }

    @Override
    public void enQueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E deQueue() {
        if(head == null){
            throw new IllegalArgumentException("can not get from empty queue");
        }else{
            Node retNode = head;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return retNode.e;
        }
    }

    @Override
    public E getFront() {
        if(head == null){
            throw new IllegalArgumentException("queue is empty get front fail!");
        }
        return this.head.e;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: font:");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
