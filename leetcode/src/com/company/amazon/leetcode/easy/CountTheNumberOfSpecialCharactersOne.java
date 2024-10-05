package com.company.amazon.leetcode.easy;

public class CountTheNumberOfSpecialCharactersOne {
    public int numberOfSpecialChars(String word) {
        /*
         * maintain a int array to keep track of characters.
         * Ascii values of A-Z are 65-90, a-z are 97-122.
         * so we will check if a Uppercase letter occurs then we check its lowercase
         * letter by doing i+32.
         * if count[i] > 0 then should exist count[i+32] > 0
         * 
         */
        int specialCharsCount = 0, n = word.length();
        var count = new int[128];
        for (int i = 0; i < n; i++) {
            count[word.charAt(i)]++;
        }

        for (int i = 65; i < 91; i++) {
            if (count[i] > 0 && count[i + 32] > 0) {
                specialCharsCount++;
            }
        }
        return specialCharsCount;
    }
}
