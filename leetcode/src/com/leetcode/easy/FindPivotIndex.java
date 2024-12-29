package com.leetcode.easy;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total_sum = Arrays.stream(nums).sum();
        int n = nums.length, left_sum = 0;
        for (int i = 0; i < n; i++) {
            total_sum -= nums[i]; // total_sum now holds the right_sum for index i
            if (total_sum == left_sum) {
                return i;
            }
            left_sum += nums[i];
        }

        return -1; // no pivot index
    }
}
