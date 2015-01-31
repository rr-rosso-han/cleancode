package binaryTree;

import java.util.Iterator;

/**
 * Created by jiahan on 1/31/15.
 */
public interface LinkedTreeIterator<E> extends Iterator<E> {
    boolean hasNext();
    E next();
}
