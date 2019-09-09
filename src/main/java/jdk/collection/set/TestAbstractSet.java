package jdk.collection.set;

import java.util.AbstractSet;
import java.util.Iterator;

public class TestAbstractSet<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
