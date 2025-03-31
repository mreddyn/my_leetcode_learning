package com.company.doordash;

import java.util.ArrayList;
import java.util.List;

public class KAnagramFinder {
    private boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // both s1 and s2 are already equal
        if (s1.equals(s2)) {
            for (int i : charCount) {
                if (i > 1) {
                    return true;
                }
            }
            return false;
        }

        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
        }

        // the chars of two strings should match
        for (int i : charCount) {
            if (i < 0) {
                return false;
            }
        }

        // count the number of characters that are different
        // if the count is less than or equal to k, return true
        // otherwise, return false

        int count = 0;
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count <= k;
    }

    public List<String> findKAnagrams(String s, List<String> words, int k) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (areKAnagrams(s, word, k)) {
                result.add(word);
            }
        }
        return result;
    }

    public int minStepsToMakeTwoStringsAnagram(String s, String t) {
        var charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        int steps = 0;

        for (int i = 0; i < 26; i++) {
            steps += Math.abs(charCount[i]);
        }

        return steps / 2;
    }

    public static void main(String[] args) {
        KAnagramFinder finder = new KAnagramFinder();
        String s = "ab";
        List<String> words = List.of("ba", "anagarm", "nagar", "gramana");
        int k = 2;

        List<String> kAnagrams = finder.findKAnagrams(s, words, k);
        System.out.println(kAnagrams); // Output: [manga, anagarm]
    }
}
