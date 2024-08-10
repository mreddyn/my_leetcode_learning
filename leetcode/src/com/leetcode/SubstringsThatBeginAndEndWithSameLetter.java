package com.leetcode;

public class SubstringsThatBeginAndEndWithSameLetter {
    private long numberOfSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        long charFrequencyMap[] = new long[26];
        for (char c : s.toCharArray()) {
            charFrequencyMap[c - 'a']++;
        }

        long goodSubStringsCount = 0;
        for (long frequency : charFrequencyMap) {
            if (frequency > 1) {
                goodSubStringsCount += (frequency * (frequency - 1)) / 2;
            }
        }
        goodSubStringsCount += s.length(); // single character substrings
        return goodSubStringsCount;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        SubstringsThatBeginAndEndWithSameLetter sbesl = new SubstringsThatBeginAndEndWithSameLetter();
        System.out.println(sbesl.numberOfSubstrings(s));
    }
}
