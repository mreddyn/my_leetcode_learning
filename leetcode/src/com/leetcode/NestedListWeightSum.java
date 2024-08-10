package com.leetcode;

import java.util.ArrayDeque;
import java.util.List;

public class NestedListWeightSum {

    private int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int n = nestedList.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nestedList.get(i).isInteger()) {
                sum += nestedList.get(i).getInteger() * depth;
            } else {
                sum += dfs(nestedList.get(i).getList(), depth + 1);
            }
        }
        return sum;
    }

    private int depthSumApproachTwo(List<NestedInteger> nestedList) {
        int n = nestedList.size();
        if (n == 0) {
            return 0;
        }
        int depth = 1;
        int sum = 0;
        ArrayDeque<NestedInteger> queue = new ArrayDeque<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nInteger = queue.poll();
                if (nInteger.isInteger()) {
                    sum += nInteger.getInteger() * depth;
                } else {
                    queue.addAll(nInteger.getList());
                }
            }
            depth++;
        }
        return sum;
    }

    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        void setInteger(int value);

        void add(NestedInteger ni);

        List<NestedInteger> getList();
    }

    public static void main(String[] args) {
        NestedListWeightSum nestedListWeightSum = new NestedListWeightSum();
        nestedListWeightSum.depthSum(null);
        nestedListWeightSum.depthSumApproachTwo(null);
    }
}
