package com.leetcode.easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, n = nums.length, curOnes = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curOnes++;
                maxOnes = Math.max(maxOnes, curOnes);
            } else {
                curOnes = 0;
            }
        }

        return maxOnes;
    }
}