package com.leetcode_daily_challenge;

public class CountNumberOfHomogenousSubstrings {
    private int countHomogenous(String s) {
        int MOD = 1000000007;
        long homogenousSubstringsCount = 0;
        int sLength = s.length();
        int windowStart = 0;
        int windowEnd = 0;
        long windowStreak = 0;
        char windowStartChar = s.charAt(windowStart);
        char windowEndChar = s.charAt(windowEnd);
        while (windowEnd < sLength) {
            if (windowStartChar == windowEndChar) {
                windowStreak++;
                windowEnd++;
                if (windowEnd < sLength) {
                    windowEndChar = s.charAt(windowEnd);
                }
            } else {
                homogenousSubstringsCount += (windowStreak * (windowStreak + 1)) / 2;
                windowStart++;
                windowStartChar = s.charAt(windowStart);
                windowStreak = 0;
            }
            homogenousSubstringsCount %= MOD;
        }
        homogenousSubstringsCount += (windowStreak * (windowStreak + 1)) / 2;
        homogenousSubstringsCount %= MOD;
        System.out.println(windowStreak);
        return (int) homogenousSubstringsCount % MOD;
    }

    public static void main(String[] args) {
        CountNumberOfHomogenousSubstrings cnhs = new CountNumberOfHomogenousSubstrings();
        System.out.println(cnhs.countHomogenous("abbcccaa"));
    }
}
