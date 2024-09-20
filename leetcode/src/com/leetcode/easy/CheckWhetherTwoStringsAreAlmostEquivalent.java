package com.leetcode.easy;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        var wordOneFreqMap = new int[26];
        var wordTwoFreqMap = new int[26];
        for (int i = 0; i < m; i++) {
            wordOneFreqMap[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            wordTwoFreqMap[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(wordOneFreqMap[i] - wordTwoFreqMap[i]);
            if (diff > 3) {
                return false;
            }
        }

        return true;
    }

    public boolean checkAlmostEquivalentApproachTwo(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        var charMap = new int[26];
        for (int i = 0; i < m; i++) {
            // increment the word1 character freq in the map .
            charMap[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            // decrement the word2 character freq in the same map.
            charMap[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            // check if final freq of a character is in the range [-3,3]
            if (charMap[i] > 3 || charMap[i] < -3) {
                return false;
            }
        }

        return true;
    }
}
