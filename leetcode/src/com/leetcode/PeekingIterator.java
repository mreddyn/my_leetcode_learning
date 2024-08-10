package com.leetcode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer peekedValue;
    PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        peekedValue = null;
    }

    @Override
    public boolean hasNext() {
        return peekedValue != null || iter.hasNext();
    }

    @Override
    public Integer next() {
        if(peekedValue != null) {
            Integer toReturn = peekedValue;
            peekedValue = null;
            return toReturn;
        }
        if(!iter.hasNext()) {
            throw new NoSuchElementException(); // or return null
        }
        return iter.next();
    }

    public Integer peek() {
        if(peekedValue == null) {
            if(!iter.hasNext()) {
                throw new NoSuchElementException();
            }
            peekedValue = iter.next();
        }
        return peekedValue;
    }
    
}
