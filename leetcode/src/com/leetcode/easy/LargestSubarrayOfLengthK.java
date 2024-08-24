package com.leetcode.easy;

import java.util.Arrays;

public class LargestSubarrayOfLengthK {
    public int[] largestSubarray(int[] nums, int k) {
        int maxIndex = 0, n = nums.length;
        for (int i = 1; i <= n - k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return Arrays.copyOfRange(nums, maxIndex, maxIndex + k);
    }
}
