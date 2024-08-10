package com.leetcode;

import java.util.HashSet;

public class CountTheNumberOfConsistentStrings {
    private int countConsistentStrings(String allowed, String[] words) {
        int consistentStringsCount = 0, allowedSize = allowed.length();
        HashSet<Character> allowedCharSet = new HashSet<>();
        for (int i = 0; i < allowedSize; i++) {
            allowedCharSet.add(allowed.charAt(i));
        }
        for (String word : words) {
            int wordSize = word.length();
            boolean isConsistent = true;
            for (int i = 0; i < wordSize; i++) {
                if (!allowedCharSet.contains(word.charAt(i))) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                consistentStringsCount++;
            }
        }

        return consistentStringsCount;
    }

    public static void main(String[] args) {
        CountTheNumberOfConsistentStrings consistentStrings = new CountTheNumberOfConsistentStrings();
        consistentStrings.countConsistentStrings("def", new String[] { "aba" });
    }
}
