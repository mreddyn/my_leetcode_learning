package com.leetcode_daily_challenge;

public class MinimumStepsToMakeTwoStringsAnagram {
    private int minSteps(String s, String t) {
        int[] sCharCount = new int[26];
        for (char c : s.toCharArray()) {
            sCharCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            sCharCount[c - 'a']--;
        }
        int minimumSteps = 0;
        for (int i = 0; i < 26; i++) {
            minimumSteps += Math.abs(sCharCount[i]);
        }
        return minimumSteps / 2;
    }

    public static void main(String[] args) {
        MinimumStepsToMakeTwoStringsAnagram solution = new MinimumStepsToMakeTwoStringsAnagram();
        System.out.println(solution.minSteps("leetcode", "practice"));
        System.out.println(solution.minSteps("anagram", "mangaar"));
    }
}
