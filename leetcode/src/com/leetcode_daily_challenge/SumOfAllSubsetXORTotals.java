package com.leetcode_daily_challenge;

public class SumOfAllSubsetXORTotals {
    private int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        // calculate sum of xor with current element
        int withElement = backtrack(nums, index + 1, currentXor ^ nums[index]);

        // calculate sum of xor without current element
        int withoutElement = backtrack(nums, index + 1, currentXor);

        return withElement + withoutElement;
    }
}
