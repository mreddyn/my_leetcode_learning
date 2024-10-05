package com.leetcode.medium;

public class LongestSubStringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int res = 0, n = s.length();
        var map = new int[26];
        int windowEnd, windowStart = 0;
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            map[s.charAt(windowEnd) - 'a']++;

            
        }

        return res;
    }
}
