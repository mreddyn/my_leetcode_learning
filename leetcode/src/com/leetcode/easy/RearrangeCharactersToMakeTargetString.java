package com.leetcode.easy;

import java.util.HashMap;

public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        /*
         * TO make copies of target from using characters of s, s needs to have all
         * chars with same or more frequencies of target.
         * The number of target copies we can make is (target char frequency in
         * s)/(target char freq in target)
         */
        int minCopiesOfTarget = Integer.MAX_VALUE;
        var sCharMap = new HashMap<Character, Integer>();
        var targetCharMap = new HashMap<Character, Integer>();
        int n = s.length(), m = target.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            sCharMap.put(c, sCharMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            if (!sCharMap.containsKey(c)) {
                // if a character from target is not present in s, then we can return false.
                return 0;
            }
            targetCharMap.put(c, targetCharMap.getOrDefault(c, 0) + 1);
        }

        for (char targetChar : targetCharMap.keySet()) {
            int targetCharFreq = targetCharMap.get(targetChar);
            int sCharFreq = sCharMap.get(targetChar);
            minCopiesOfTarget = Math.min(minCopiesOfTarget, (sCharFreq / targetCharFreq));
        }

        return minCopiesOfTarget;
    }

    public int rearrangeCharactersApproachTwo(String s, String target) {
        /*
         * TO make copies of target from using characters of s, s needs to have all
         * chars with same or more frequencies of target.
         * The number of target copies we can make is (target char frequency in
         * s)/(target char freq in target)
         */
        int minCopiesOfTarget = Integer.MAX_VALUE, n = s.length(), m = target.length();
        var sCharMap = new int[26];
        var targetCharMap = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            sCharMap[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            if (sCharMap[c - 'a'] == 0) {
                // if a character from target is not present in s, then we can return false.
                return 0;
            }
            targetCharMap[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            int index = target.charAt(i) - 'a';
            minCopiesOfTarget = Math.min(minCopiesOfTarget, (sCharMap[index] / targetCharMap[index]));
        }

        return minCopiesOfTarget;
    }
}
