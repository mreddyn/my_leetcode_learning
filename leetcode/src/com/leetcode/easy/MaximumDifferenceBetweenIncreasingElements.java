package com.leetcode.easy;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        /*
         * This problem is similar to buy stocks.
         * We need to buy on lowest day and sell it on highest day.
         * we can only sell after we buy that is lowest val should always come before
         * highest val.
         */
        int maxDiff = -1, minVal = nums[0], maxVal = nums[1], n = nums.length;
        maxDiff = Math.max(maxDiff, maxVal - minVal);
        for (int i = 1; i < n; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxDiff = Math.max(maxDiff, maxVal - minVal);
            }
            if (nums[i] < minVal) {
                minVal = nums[i];
                maxVal = nums[i];
            }
        }

        return maxDiff == 0 ? -1 : maxDiff;
    }
}
