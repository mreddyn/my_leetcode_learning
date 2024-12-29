package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class SwapForLongestRepeatedCharacterSubString {

    public int maxRepOpt1(String text) {
        /*
         * There are only 2 cases that we need to take care of:
         * 
         * extend the group by 1
         * merge 2 adjacent groups together, which are separated by only 1 character
         */
        int longest = 0, n = text.length();
        // map to store indices for each char
        var map = new HashMap<Character, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            var c = text.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        for (var indices : map.values()) {
            // Iterate through each character indices
            int curLen = 1, prevLen = 0, maxLen = 1, len = indices.size();
            for (int i = 1; i < len; i++) {
                int cur_index = indices.get(i);
                int prev_index = indices.get(i - 1);
                if (cur_index == prev_index + 1) {
                    // if characters are contiguous
                    curLen++;
                } else if (cur_index == prev_index + 2) {
                    // if characters are not contiguous but are separated by a another char
                    // then store the previous group in prevLen and set current group size to 1
                    prevLen = curLen;
                    curLen = 1;
                } else {
                    // else reset
                    prevLen = 0;
                    curLen = 1;
                }
                // calculate the max size by combining two groups
                maxLen = Math.max(maxLen, curLen + prevLen);
            }

            if (maxLen < len) {
                maxLen++;
            }
            longest = Math.max(longest, maxLen);
        }

        return longest;
    }
}
