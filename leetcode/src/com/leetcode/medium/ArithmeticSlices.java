package com.leetcode.medium;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int totalArithmeticSlicesCount = 0, n = nums.length, curArithmeticSlice = 0;

        // Iterate over the nums array starting from index 2
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                // if the numbers from current consecutive three indices form a arithmetic slice
                // then increase the counter and it to total slices.
                // if not reset the counter
                curArithmeticSlice++;
                totalArithmeticSlicesCount += curArithmeticSlice;
            } else {
                curArithmeticSlice = 0;
            }
        }

        return totalArithmeticSlicesCount;
    }
}
