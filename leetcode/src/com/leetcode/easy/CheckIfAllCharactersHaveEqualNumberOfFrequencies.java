package com.leetcode.easy;

public class CheckIfAllCharactersHaveEqualNumberOfFrequencies {
    public boolean areOccurrencesEqual(String s) {
        /*
         * we will calculate the occurrence of each char in string s.
         * Take the frequency of the first char in string s and iterate through the
         * count array
         * to check if all chars have same frequency if their frequency is greater than
         * zero.
         */
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int freq = count[s.charAt(0) - 'a'];
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] != freq) {
                return false;
            }
        }

        return true;
    }
}
