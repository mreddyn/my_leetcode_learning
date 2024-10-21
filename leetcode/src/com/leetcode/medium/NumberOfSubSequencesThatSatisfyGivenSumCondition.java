package com.leetcode.medium;

import java.util.Arrays;

public class NumberOfSubSequencesThatSatisfyGivenSumCondition {
    public int numSubSeq(int[] nums, int target) {
        Arrays.sort(nums);
        final int MOD = (int) 1e9 + 7;
        int res = 0, n = nums.length, left = 0, right = nums.length - 1;
        var powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                res = (res + powers[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
