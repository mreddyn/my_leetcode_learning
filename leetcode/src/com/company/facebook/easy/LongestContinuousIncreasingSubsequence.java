package com.company.facebook.easy;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int longestIncreasingSubArrayCount = 1, curIncreasingSubArrayCount = 1, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                curIncreasingSubArrayCount++;
            } else {
                curIncreasingSubArrayCount = 1;
            }

            longestIncreasingSubArrayCount = Math.max(longestIncreasingSubArrayCount, curIncreasingSubArrayCount);
        }

        return longestIncreasingSubArrayCount;
    }
}
