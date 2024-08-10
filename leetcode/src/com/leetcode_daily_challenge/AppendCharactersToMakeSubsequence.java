package com.leetcode_daily_challenge;

public class AppendCharactersToMakeSubsequence {
    private int appendCharacters(String s, String t) {
        int m = s.length(), n = t.length(), sIndex = 0, tIndex = 0;
        for (sIndex = 0; sIndex < m && tIndex < n; sIndex++) {
            tIndex += (s.charAt(sIndex) == t.charAt(tIndex)) ? 1 : 0;
        }
        return n - tIndex;
    }

    public static void main(String[] args) {
        AppendCharactersToMakeSubsequence aMakeSubsequence = new AppendCharactersToMakeSubsequence();
        System.out.println(aMakeSubsequence.appendCharacters("coaching", "coding"));
        System.out.println(aMakeSubsequence.appendCharacters("abcde", "a"));
        System.out.println(aMakeSubsequence.appendCharacters("z", "abcde"));
    }
}
