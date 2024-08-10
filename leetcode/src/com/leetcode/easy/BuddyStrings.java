package com.leetcode.easy;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n == 1 || m != n) {
            return false;
        }
        // if strings s and goal are equal then we need to check the occurrences, as if
        // a char is repeated
        // then swapping does not change, so we can return true.
        int[] charCount = new int[26];
        for (int i = 0; i < n; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        if (s.equals(goal)) {
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > 1) {
                    return true;
                }
            }
            return false;
        }

        // check for frequencies, the characters of two strings frequencies should match
        for (int i = 0; i < n; i++) {
            charCount[goal.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        // there should be only two positions where the characters should not match
        int nonEqualPositionsCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                nonEqualPositionsCount++;
            }
        }

        return nonEqualPositionsCount == 2;
    }
}
