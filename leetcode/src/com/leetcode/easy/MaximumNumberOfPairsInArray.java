package com.leetcode.easy;

public class MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length, pairsCount = 0, leftOverCount = 0;
        int[] count = new int[101];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < 101; i++) {
            if (count[i] % 2 == 0) {
                pairsCount += count[i] / 2;
            } else {
                pairsCount += (count[i] - 1) / 2;
                leftOverCount++;
            }
        }
        return new int[] { pairsCount, leftOverCount };
    }
}
