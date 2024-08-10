package com.company.hubspot.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumNumberOfOccurrencesOfASubString {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        /*
         * Add substrings of size minSize to hashMap to maintain the occurrences.
         * Now loop through the substrings in the HashMap and check if it is valid or
         * not.
         */
        int maxSubStringFreq = 0, n = s.length();
        HashMap<String, Integer> subStringMap = new HashMap<>();
        for (int beginIndex = 0; beginIndex + minSize - 1 < n; beginIndex++) {
            String subStr = s.substring(beginIndex, beginIndex + minSize);
            subStringMap.put(subStr, subStringMap.getOrDefault(subStr, 0) + 1);
        }

        for (String key : subStringMap.keySet()) {
            HashSet<Character> charSet = new HashSet<>();
            int size = key.length();
            for (int i = 0; i < size; i++) {
                charSet.add(key.charAt(i));
            }

            if (charSet.size() <= maxLetters) {
                maxSubStringFreq = Math.max(maxSubStringFreq, subStringMap.get(key));
            }
        }

        return maxSubStringFreq;
    }

    public static void main(String[] args) {
        MaximumNumberOfOccurrencesOfASubString mASubString = new MaximumNumberOfOccurrencesOfASubString();
        System.out.println(mASubString.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(mASubString.maxFreq("aaaa", 1, 3, 3));
    }
}
