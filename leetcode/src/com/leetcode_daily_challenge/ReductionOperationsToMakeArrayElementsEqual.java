package com.leetcode_daily_challenge;

import java.util.Arrays;

public class ReductionOperationsToMakeArrayElementsEqual {
    private int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;
        int operations = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                operations += count;
                count++;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        ReductionOperationsToMakeArrayElementsEqual reductionOperationsToMakeArrayElementsEqual = new ReductionOperationsToMakeArrayElementsEqual();
        System.out
                .println(reductionOperationsToMakeArrayElementsEqual.reductionOperations(new int[] { 1, 1, 1 }));
    }
}
