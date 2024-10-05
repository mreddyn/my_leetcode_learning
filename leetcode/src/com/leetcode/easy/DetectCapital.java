package com.leetcode.easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length(), uppercaseLetterCount = 0;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                uppercaseLetterCount++;
            }
        }

        if (uppercaseLetterCount == 0) {
            // no uppercase letters, all lowercase letters
            return true;
        } else if (uppercaseLetterCount == 1 && word.charAt(0) >= 65 && word.charAt(0) <= 90) {
            // if there is only one uppercase letter, then it should be first char in word
            // string
            return true;
        } else if (uppercaseLetterCount == n) {
            // if all letters of word are uppercase then it should match the length
            return true;
        }

        return false;
    }
}
