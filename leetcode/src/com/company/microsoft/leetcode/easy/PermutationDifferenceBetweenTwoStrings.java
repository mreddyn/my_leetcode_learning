package com.company.microsoft.leetcode.easy;

public class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        /*
         * Maintain a hashmap or int array to store indices of chars for string t.
         * Iterate through string s, for each char find the corresponding index of t in
         * map and add difference
         */
        int permutationDiff = 0, n = t.length();
        int[] charIndex = new int[26];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            charIndex[c - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            permutationDiff += Math.abs(i - charIndex[c - 'a']);
        }

        return permutationDiff;
    }
}
