package jdk.collection.list;

import java.util.AbstractList;

public class TestAbstractList<E> extends AbstractList<E> {
    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
