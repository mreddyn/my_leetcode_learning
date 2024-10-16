package com.leetcode.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, valCount = 0;
        for (int num : nums) {
            if (num == val) {
                valCount++;
            }
        }

        int nonValIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[nonValIndex++] = nums[i];
            }
        }

        return n - valCount;
    }
}
