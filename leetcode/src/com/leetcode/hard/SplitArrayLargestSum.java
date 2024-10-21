package com.leetcode.hard;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int maxSum = 0, totalSum = 0;
        for (int num : nums) {
            maxSum = Math.max(maxSum, num);
            totalSum += num;
        }

        int left = maxSum, right = totalSum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int allowedSum, int k) {
        int subArraysCount = 1, runningSum = 0;
        for (int num : nums) {
            runningSum += num;

            if (runningSum > allowedSum) {
                runningSum = num;
                subArraysCount++;
            }

            if (subArraysCount > k) {
                return false;
            }
        }

        return true;
    }
}
