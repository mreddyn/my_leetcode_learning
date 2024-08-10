package com.leetcode_daily_challenge;

import java.util.Arrays;

public class UniqueLengthThreePalindromicSubsequences {
    int uniquePalindromicSubSequencesCount = 0;

    private int countPalindromicSubsequence(String s) {
        int sLength = s.length();
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < sLength; i++) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                uniqueCharsInString(s.substring(first[i] + 1, last[i]));
            }
        }
        return uniquePalindromicSubSequencesCount;
    }

    private void uniqueCharsInString(String s) {
        System.out.println(s);
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                uniquePalindromicSubSequencesCount++;
            }
        }
    }

    public static void main(String[] args) {
        UniqueLengthThreePalindromicSubsequences ul = new UniqueLengthThreePalindromicSubsequences();
        System.out.println(ul.countPalindromicSubsequence("bbcbaba"));
    }
}
