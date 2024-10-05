package com.leetcode.medium;

public class NumberOfZeroFilledSubArrays {
    public long zeroFilledSubarray(int[] nums) {
        long totalZeroArraysCount = 0, zeros = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                totalZeroArraysCount += zeros;
            } else {
                zeros = 0;
            }
        }

        return totalZeroArraysCount;
    }
}
