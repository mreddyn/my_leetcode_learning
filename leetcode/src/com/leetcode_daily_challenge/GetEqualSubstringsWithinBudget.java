package com.leetcode_daily_challenge;

public class GetEqualSubstringsWithinBudget {
    private int equalSubstring(String s, String t, int budget) {
        int maxLengthOfEqualSubstring = 0, windowStart, windowEnd, currentBudget, n = s.length();
        windowStart = 0;
        windowEnd = 0;
        currentBudget = 0;
        while (windowEnd < n) {
            currentBudget += Math.abs(s.charAt(windowEnd) - t.charAt(windowEnd));
            while (currentBudget > budget) {
                currentBudget -= Math.abs(s.charAt(windowStart) - t.charAt(windowStart));
                windowStart++;
            }
            maxLengthOfEqualSubstring = Math.max(maxLengthOfEqualSubstring, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxLengthOfEqualSubstring;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget gEqualSubstringsWithinBudget = new GetEqualSubstringsWithinBudget();
        System.out.println(gEqualSubstringsWithinBudget.equalSubstring("abcd", "bcdf", 3));
    }
}
