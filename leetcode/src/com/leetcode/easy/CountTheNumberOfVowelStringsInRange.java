package com.leetcode.easy;

import java.util.Set;

public class CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int vowelStringsCount = 0;
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = left; i <= right; i++) {
            String word = words[i];

            if (vowelSet.contains(word.charAt(0)) && vowelSet.contains(word.charAt(word.length() - 1))) {
                vowelStringsCount++;
            }
        }

        return vowelStringsCount;
    }
}
