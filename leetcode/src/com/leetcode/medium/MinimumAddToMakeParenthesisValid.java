package com.leetcode.medium;

public class MinimumAddToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        int stackSize = 0, mismatch = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stackSize++;
            } else {
                if (stackSize > 0) {
                    stackSize--;
                } else {
                    mismatch++;
                }
            }
        }

        return stackSize + mismatch;
    }
}
