package com.leetcode.medium;

import java.util.ArrayDeque;

public class MinimumNumberOfSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        /*
         * We can discard the balanced brackets.
         * mismatches = 0, 1, 2, 3, 4, 5, 6, 7
         * swaps req = 0, 1, 1, 2, 2, 3, 3, 4
         * 
         * Iterate through the string.
         * if we encounter a opening then push it to stack.
         * else if stack is empty then increment mismatch.
         * else pop the opening bracket from stack
         */
        int n = s.length(), mismatch = 0;
        var stack = new ArrayDeque<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    mismatch++;
                } else {
                    stack.pop();
                }
            }
        }

        return (mismatch + 1) / 2;
    }

    public int minSwapsApproachTwo(String s) {
        int n = s.length(), stackSize = 0, mismatch = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                // if we encounter a open bracket increment the stackSize
                stackSize++;
            } else {
                // check if the stack has enough open brackets
                if (stackSize > 0) {
                    stackSize--;
                } else {
                    mismatch++;
                }
            }
        }

        return (mismatch + 1) / 2;
    }
}
