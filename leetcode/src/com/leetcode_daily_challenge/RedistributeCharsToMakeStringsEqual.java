package com.leetcode_daily_challenge;

public class RedistributeCharsToMakeStringsEqual {
    private boolean makeEqual(String[] words) {
        int totalWords = words.length;
        int[] charCount = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] % totalWords != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RedistributeCharsToMakeStringsEqual r = new RedistributeCharsToMakeStringsEqual();
        String[] words = { "ab", "a" };
        System.out.println(r.makeEqual(words));
    }
}
