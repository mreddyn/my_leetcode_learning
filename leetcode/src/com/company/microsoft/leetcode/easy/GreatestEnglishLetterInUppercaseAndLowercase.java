package com.company.microsoft.leetcode.easy;

public class GreatestEnglishLetterInUppercaseAndLowercase {
    public String greatestLetter(String s) {
        int n = s.length();
        int[] lowerCaseCount = new int[26];
        int[] upperCaseCount = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerCaseCount[c - 'a']++;
            } else {
                upperCaseCount[c - 'A']++;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (lowerCaseCount[i] > 0 && upperCaseCount[i] > 0) {
                return "" + ((char) ('A' + i));
            }
        }

        return "";
    }
}
