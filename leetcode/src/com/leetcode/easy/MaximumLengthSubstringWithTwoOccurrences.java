package com.leetcode.easy;

import java.util.HashMap;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        /*
         * Maintain a sliding window to keep track of length of chars in map whose freq
         * <= 2.
         * Decrease the window when the char freq > 2.
         */
        int maxLength = 0, n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int windowEnd = 0, windowStart = 0, curLength = 0;
        while (windowEnd < n) {
            char windowEndChar = s.charAt(windowEnd);
            map.put(windowEndChar, map.getOrDefault(windowEndChar, 0) + 1);
            while (map.get(windowEndChar) > 2) {
                char windowStartChar = s.charAt(windowStart);
                map.put(windowStartChar, map.get(windowStartChar) - 1);
                windowStart++;
            }

            curLength = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, curLength);
            windowEnd++;
        }

        return maxLength;
    }

    public int maximumLengthSubstringApproachTwo(String s) {
        int maxLength = 0, n = s.length();
        int[] charCount = new int[26];
        int windowEnd = 0, windowStart = 0, curLength = 0;
        while (windowEnd < n) {
            char windowEndChar = s.charAt(windowEnd);
            charCount[windowEndChar - 'a']++;
            while (charCount[windowEndChar - 'a'] > 2) {
                char windowStartChar = s.charAt(windowStart);
                charCount[windowStartChar - 'a']--;
                windowStart++;
            }

            curLength = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, curLength);
            windowEnd++;
        }

        return maxLength;
    }
}
