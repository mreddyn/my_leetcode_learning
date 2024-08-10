package com.leetcode_daily_challenge;

public class LargestSubstringBetweenTwoEqualCharacters {
    private int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstIndex[index] == 0) {
                firstIndex[index] = i + 1;
            }
            lastIndex[index] = i + 1;
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (firstIndex[i] != 0 && lastIndex[i] != 0) {
                max = Math.max(max, lastIndex[i] - firstIndex[i] - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters l = new LargestSubstringBetweenTwoEqualCharacters();
        String s = "aa";
        System.out.println(l.maxLengthBetweenEqualCharacters(s));
    }
}
