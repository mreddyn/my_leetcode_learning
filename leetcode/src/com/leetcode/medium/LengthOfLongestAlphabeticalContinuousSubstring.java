package com.leetcode.medium;

public class LengthOfLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int maxContinuousStrLength = 1, curContinuousStrLength = 1, n = s.length();
        for (int i = 1; i < n; i++) {
            char curChar = s.charAt(i), prevChar = s.charAt(i - 1);
            if (prevChar + 1 == curChar) {
                curContinuousStrLength++;
            } else {
                curContinuousStrLength = 1;
            }

            maxContinuousStrLength = Math.max(maxContinuousStrLength, curContinuousStrLength);
        }

        return maxContinuousStrLength;
    }
}
