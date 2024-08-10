package com.leetcode;

import java.util.HashMap;

public class LongestSubStringWithAtMostTwoDistinctCharacters {
    private int lengthOfLongestSubStringTwoDistinct(String s) {
        int longestSubStringSize = 0, windowEnd, windowStart = 0, n = s.length();
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        char ch[] = s.toCharArray();
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            charFreqMap.put(ch[windowEnd], charFreqMap.getOrDefault(ch[windowEnd], 0) + 1);
            if (charFreqMap.size() <= 2) {
                longestSubStringSize = Math.max(windowEnd - windowStart + 1, longestSubStringSize);
            }
            while (charFreqMap.size() > 2) {
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
        LongestSubStringWithAtMostTwoDistinctCharacters longestSubStringWithAtMostTwoDistinctCharacters = new LongestSubStringWithAtMostTwoDistinctCharacters();
        System.out
                .println(longestSubStringWithAtMostTwoDistinctCharacters.lengthOfLongestSubStringTwoDistinct("eceba"));
        System.out.println(
                longestSubStringWithAtMostTwoDistinctCharacters.lengthOfLongestSubStringTwoDistinct("ccaabbb"));
    }

}
