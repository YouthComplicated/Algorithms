package base;

public interface Statck<E> {

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
