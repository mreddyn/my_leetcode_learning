package com.leetcode.medium;

public class MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSubArraySum = Integer.MIN_VALUE, minSubArraySum = Integer.MAX_VALUE, totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        return maxSubArraySum;
    }
}
