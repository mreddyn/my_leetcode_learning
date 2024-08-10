package com.company.microsoft.leetcode;

import java.util.HashSet;

public class LongestPalindrome {
    private int longestPalindrome(String s) {
        int n = s.length(), maxSizePalindromePossible = 0;
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (seen.contains(c)) {
                seen.remove(c);
                maxSizePalindromePossible++;
            } else {
                seen.add(c);
            }
        }
        // odd palindrome
        if (!seen.isEmpty()) {
            return maxSizePalindromePossible * 2 + 1;
        }
        return maxSizePalindromePossible * 2;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }
}
