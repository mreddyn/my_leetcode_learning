package com.leetcode;

import java.util.HashMap;

public class LongestSubStringWithAtMostKDistinctCharacters {
    private int lengthOfLongestSubStringKDistinct(String s, int k) {
        int longestSubStringSize = 0, windowEnd, windowStart = 0, n = s.length();
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        char ch[] = s.toCharArray();
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            charFreqMap.put(ch[windowEnd], charFreqMap.getOrDefault(ch[windowEnd], 0) + 1);
            if (charFreqMap.size() <= k) {
                longestSubStringSize = Math.max(windowEnd - windowStart + 1, longestSubStringSize);
            }
            while (charFreqMap.size() > k) {
                charFreqMap.put(ch[windowStart], charFreqMap.get(ch[windowStart]) - 1);
                if (charFreqMap.get(ch[windowStart]) == 0) {
                    charFreqMap.remove(ch[windowStart]);
                }
                windowStart++;
            }
        }

        return longestSubStringSize;
    }

    public static void main(String[] args) {
        LongestSubStringWithAtMostKDistinctCharacters longestSubStringWithAtMostKDistinctCharacters = new LongestSubStringWithAtMostKDistinctCharacters();
        System.out.println(longestSubStringWithAtMostKDistinctCharacters.lengthOfLongestSubStringKDistinct("eceba", 2));
    }
}
