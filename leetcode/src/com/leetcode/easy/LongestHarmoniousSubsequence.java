package com.leetcode.easy;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        /*
         * we need to find a number and number+1 or number-1 exists in the array, if
         * they exist
         * count all their frequencies, that will be the max length of LHS.
         * On further improvement, we don't need to check for number-1 in the HashMap
         * since
         * when we are checking for number-1 as key then we will find number as
         * sequence.
         */
        int longestHarmoniousSubsequenceLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int currentLHSLength = 0;
            if (map.containsKey(key + 1)) {
                currentLHSLength = map.get(key) + map.get(key + 1);
            }
            longestHarmoniousSubsequenceLength = Math.max(longestHarmoniousSubsequenceLength, currentLHSLength);
        }

        return longestHarmoniousSubsequenceLength;
    }
}
