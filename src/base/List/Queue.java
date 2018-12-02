package base.List;

public interface Queue<E> {

    void enQueue(E e);
    E deQueue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
