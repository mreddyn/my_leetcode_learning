package com.leetcode;

public class ConsecutiveCharacters {
    private int maxPower(String s) {
        int sLength = s.length();
        int windowStart = 0;
        int windowEnd = 0;
        int windowStreak = 0;
        char windowStartChar = s.charAt(windowStart);
        char windowEndChar = s.charAt(windowEnd);
        int maxWindowStreak = 0;
        while (windowEnd < sLength) {
            if (windowStartChar == windowEndChar) {
                windowStreak++;
                windowEnd++;
                if (windowEnd < sLength) {
                    windowEndChar = s.charAt(windowEnd);
                }
            } else {
                maxWindowStreak = Math.max(maxWindowStreak, windowStreak);
                windowStart++;
                windowStartChar = s.charAt(windowStart);
                windowStreak = 0;
            }
        }
        maxWindowStreak = Math.max(maxWindowStreak, windowStreak);
        return maxWindowStreak;
    }

    public static void main(String[] args) {
        ConsecutiveCharacters cc = new ConsecutiveCharacters();
        System.out.println(cc.maxPower("abbcccddddeeeeedcba"));
    }
}
