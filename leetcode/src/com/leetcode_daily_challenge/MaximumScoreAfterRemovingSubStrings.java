package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class MaximumScoreAfterRemovingSubStrings {
    private int maxGain;

    public int maximumGain(String s, int x, int y) {
        /*
         * We will try to remove all highPriority pairs first from string s
         * then we in second pass we will remove lowPriorityPairs
         * HighPriority and lowPriority are calculated using x and y
         */
        maxGain = 0;
        int highPriorityPairPoints = Math.max(x, y), lowPriorityPairPoints = Math.min(x, y);
        String highPriorityPair = (x > y) ? "ab" : "ba";
        String lowPriorityPair = (highPriorityPair.equals("ab")) ? "ba" : "ab";
        String afterRemovingHighPriorityPairs = removePriorityPairs(s, highPriorityPair, highPriorityPairPoints);
        removePriorityPairs(afterRemovingHighPriorityPairs, lowPriorityPair, lowPriorityPairPoints);
        return maxGain;
    }

    private String removePriorityPairs(String s, String pair, int points) {
        // pair will be "ab" or "ba"
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(curChar);
                continue;
            }
            char topChar = stack.peek();
            if (topChar == pair.charAt(0) && curChar == pair.charAt(1)) {
                maxGain += points;
                stack.pop();
            } else {
                stack.push(curChar);
            }
        }
        int size = stack.size();
        StringBuilder sb = new StringBuilder(n);
        while (size-- > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MaximumScoreAfterRemovingSubStrings mScoreAfterRemovingSubStrings = new MaximumScoreAfterRemovingSubStrings();
        System.out.println(mScoreAfterRemovingSubStrings.maximumGain("cdbcbbaaabab", 4, 5));
    }

}
