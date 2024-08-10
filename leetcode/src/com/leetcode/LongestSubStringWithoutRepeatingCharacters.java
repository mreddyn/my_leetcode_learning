package com.leetcode;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {
    private int lengthOfLongestSubString(String s) {
        int longestUniqueCharSubStringSize = 0, n = s.length(), windowEnd, windowStart = 0;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for(windowEnd = 0; windowEnd < n; windowEnd++) {
            while(charFreqMap.containsKey(s.charAt(windowEnd))){
                charFreqMap.remove(s.charAt(windowStart));
                windowStart++;
            }
            charFreqMap.put(s.charAt(windowEnd), windowEnd);
            longestUniqueCharSubStringSize = Math.max(longestUniqueCharSubStringSize, windowEnd - windowStart+1);

        }
        return longestUniqueCharSubStringSize;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters longestSubStringWithoutRepeatingCharacters = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(longestSubStringWithoutRepeatingCharacters.lengthOfLongestSubString("abcabcbb"));
    }
}
