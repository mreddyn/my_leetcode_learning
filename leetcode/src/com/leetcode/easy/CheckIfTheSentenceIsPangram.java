package com.leetcode.easy;

import java.util.HashSet;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        int[] charCount = new int[26];
        int n = sentence.length();
        for (int i = 0; i < n; i++) {
            charCount[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangramApproachTwo(String sentence) {
        HashSet<Character> charSet = new HashSet<>();
        int n = sentence.length();
        for (int i = 0; i < n; i++) {
            charSet.add(sentence.charAt(i));
        }

        return charSet.size() == 26;
    }
}
