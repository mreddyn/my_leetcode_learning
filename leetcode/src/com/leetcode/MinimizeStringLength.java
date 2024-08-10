package com.leetcode;

public class MinimizeStringLength {
    public int minimizedStringLength(String s) {
        int n = s.length(), uniqueCharCount = 0;
        int[] freqCount = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freqCount[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freqCount[i] > 0) {
                uniqueCharCount++;
            }
        }

        return uniqueCharCount;
    }
}
