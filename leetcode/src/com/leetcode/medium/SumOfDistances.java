package com.leetcode.medium;

import java.util.HashMap;

public class SumOfDistances {
    public long[] distance(int[] nums) {
        /*
         * We first go left-to-right, and for each number we track:
         * 
         * sum of indexes
         * cnt of indexes
         * The resulting value for element n[i] is cnt[n[i]] * i - sum[n[i]].
         * 
         * Then, we repeat the same going right-to-left.
         */
        int n = nums.length;
        var result = new long[n];
        var countMap = new HashMap<Integer, Long>();
        var sumMap = new HashMap<Integer, Long>();

        // Iterate from left to right
        for (int i = 0; i < n; i++) {
            result[i] += countMap.getOrDefault(nums[i], 0l) * i - sumMap.getOrDefault(nums[i], 0l);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0l) + 1);
            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0l) + i);
        }

        countMap.clear();
        sumMap.clear();

        // now Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += sumMap.getOrDefault(nums[i], 0l) - countMap.getOrDefault(nums[i], 0l) * i;
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0l) + 1);
            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0l) + i);
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfDistances sDistances = new SumOfDistances();
        sDistances.distance(new int[] { 1, 3, 1, 1, 2 });
    }
}
