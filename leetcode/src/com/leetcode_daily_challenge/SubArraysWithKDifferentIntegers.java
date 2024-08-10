package com.leetcode_daily_challenge;

import java.util.HashMap;

public class SubArraysWithKDifferentIntegers {
    private static int subArraysWithKDistinct(int[] nums, int k) {

        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
    }

    private static int slidingWindowAtMost(int[] nums, int k) {
        int subArraysCount = 0, n = nums.length, windowEnd, windowStart = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            freqMap.put(nums[windowEnd], freqMap.getOrDefault(nums[windowEnd], 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(nums[windowStart], freqMap.get(nums[windowStart]) - 1);
                if (freqMap.get(nums[windowStart]) == 0) {
                    freqMap.remove(nums[windowStart]);
                }
                windowStart++;
            }
            subArraysCount += windowEnd - windowStart + 1;
        }

        return subArraysCount;
    }

    public static void main(String[] args) {
        System.out.println(subArraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
    }
}
