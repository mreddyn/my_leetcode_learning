package com.leetcode.easy;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
            if (count[ch - 'a'] > 1) {
                return ch;
            }
        }

        return 'a';
    }
}
