package com.leetcode.easy;

public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        /*
         * Maintain a StringBuilder which is initialized with word, and a counter with
         * zero.
         * we will check if word is a substring of sequence.
         * if it is a substring then append word again, increment the counter and repeat
         * the same.
         * else break the loop and return.
         */
        int wordRepeatCount = 0, n = sequence.length();
        StringBuilder sb = new StringBuilder(word);
        while (sb.length() <= n) {
            if (!isSubstring(sequence, sb.toString())) {
                break;
            }
            wordRepeatCount++;
            sb.append(word);
        }

        return wordRepeatCount;
    }

    private boolean isSubstring(String sequence, String s) {
        return sequence.contains(s);
    }
}
