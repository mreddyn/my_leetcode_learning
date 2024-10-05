package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

public class CountTheNumberOfSpecialCharactersTwo {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        var charCount = new int[128];
        Arrays.fill(charCount, -1);
        for (int i = n - 1; i >= 0; i--) {
            // record the leftmost index of a char
            charCount[word.charAt(i)] = i;
        }

        var specialCharsSet = new HashSet<Character>();

        for (int i = 0; i < n; i++) {
            // loop through the word
            int charVal = word.charAt(i);
            if (charVal >= 97 && charVal <= 122) {
                // if the current char is a lowercase english letter
                // we need to check every occurrence of lowercase letter appears
                // before first occurrence of uppercase letter
                int upperCaseLetterIndex = charCount[charVal - 32];
                if (upperCaseLetterIndex == -1) {
                    // if there is no uppercase letter for the current lowercase then ignore
                    continue;
                }
                int lowercaseLetterIndex = i;
                if (lowercaseLetterIndex < upperCaseLetterIndex) {
                    // if the lowercase letter occurs before uppercase then add it to set
                    specialCharsSet.add(word.charAt(i));
                } else {
                    // if lowercase letter does not occur then remove it from set,
                    // as every lowercase letter should occur before uppercase
                    specialCharsSet.remove(word.charAt(i));
                }
            }
        }

        return specialCharsSet.size();
    }

    public int numberOfSpecialCharsApproachTwo(String word) {
        int specialCharsCount = 0, n = word.length();
        var upperCaseCount = new boolean[26];
        var lowerCaseCount = new boolean[26];

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                // if current char is lowercase then check if their exists a uppercase char
                // before
                boolean isUpperCaseCharExistsBefore = upperCaseCount[c - 'a'];
                if (isUpperCaseCharExistsBefore) {
                    // if exists then make the current lowercase char as false
                    lowerCaseCount[c - 'a'] = false;
                } else {
                    lowerCaseCount[c - 'a'] = true;
                }

            } else {
                upperCaseCount[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            // for every char present in word, count if their exists lowercase and uppercase
            specialCharsCount += (lowerCaseCount[i] && upperCaseCount[i]) ? 1 : 0;
        }

        return specialCharsCount;
    }

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersTwo cTwo = new CountTheNumberOfSpecialCharactersTwo();
        System.out.println(cTwo.numberOfSpecialChars("aaAbcBC"));
        System.out.println(cTwo.numberOfSpecialChars("abc"));
        System.out.println(cTwo.numberOfSpecialChars("AbBCab"));
    }
}
