package com.leetcode;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
    ArrayDeque<NestedInteger> stack;

    FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        int size = nestedList.size();
        for (int i = size - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
