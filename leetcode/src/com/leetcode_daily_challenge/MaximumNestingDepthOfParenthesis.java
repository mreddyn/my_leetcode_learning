package com.leetcode_daily_challenge;

public class MaximumNestingDepthOfParenthesis {
    private int maxDepth(String s) {
        int curDepth = 0, maxDepth = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                curDepth++;
                maxDepth = Math.max(maxDepth, curDepth);
            } else if (c == ')') {
                curDepth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfParenthesis maximumNestingDepthOfParenthesis = new MaximumNestingDepthOfParenthesis();
        System.out.println(maximumNestingDepthOfParenthesis.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
