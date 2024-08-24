package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        /*
         * The problem is not asking for sub sequence but for minimum suffix sum >
         * prefix sum.
         * To so this we will calculate totalSum and sort the array.
         * Iterate through the end, and maintain suffixSum.
         * Whenever a suffixSum > prefixSum (totalSum - suffixSum) we will exit the loop
         * after noting its index.
         */
        int n = nums.length, totalSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        Arrays.sort(nums);
        int suffixSum = 0, suffixIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum += nums[i];
            if (suffixSum > totalSum - suffixSum) {
                suffixIndex = i;
                break;
            }
        }

        for (int i = n - 1; i >= suffixIndex; i--) {
            result.add(nums[i]);
        }

        return result;
    }
}
