package com.leetcode.easy;

public class LongestStrictlyIncreasingOrDecreasingSubArray {
    public int longestMonotonicSubArray(int[] nums) {
        int longestIncreasingSubArraySize = 1, longestDecreasingSubArraySize = 1, n = nums.length;
        int curIncreasingSubArraySize = 1, curDecreasingSubArraySize = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                curIncreasingSubArraySize++;
            } else {
                longestIncreasingSubArraySize = Math.max(curIncreasingSubArraySize, longestIncreasingSubArraySize);
                curIncreasingSubArraySize = 1;
            }

            if (nums[i] < nums[i - 1]) {
                curDecreasingSubArraySize++;
            } else {
                longestDecreasingSubArraySize = Math.max(curDecreasingSubArraySize, longestDecreasingSubArraySize);
                curDecreasingSubArraySize = 1;
            }
        }
        longestIncreasingSubArraySize = Math.max(curIncreasingSubArraySize, longestIncreasingSubArraySize);
        longestDecreasingSubArraySize = Math.max(curDecreasingSubArraySize, longestDecreasingSubArraySize);

        return Math.max(longestIncreasingSubArraySize, longestDecreasingSubArraySize);
    }
}
