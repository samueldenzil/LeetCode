// https://leetcode.com/problems/peeking-iterator/
package All_Problems;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    // Peek element
    Integer nextEl = null;
    Iterator<Integer> it = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        nextEl = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEl;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer getElement = nextEl;
        if (it.hasNext()) {
            nextEl = it.next();
        } else {
            nextEl = null;
        }

        return getElement;
    }

    @Override
    public boolean hasNext() {
        return nextEl != null;
    }
}